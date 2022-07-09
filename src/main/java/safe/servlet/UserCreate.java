package safe.servlet;

import safe.dal.UserDao;
import safe.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/usercreate")
public class UserCreate extends HttpServlet {

    protected UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = UserDao.getInstance();
    }

    /**
     * The doGet() method is called by the server (via the service method) to allow a servlet to handle a GET request.
     * Generally, we use the doGet() method for getting the information from the server.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
    }


    /**
     * The doPost() method is called by the server (via the service method) to allow a servlet to handle a POST request.
     * Generally, we use the doPost() method for sending information to the server like HTML form data.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String userName = req.getParameter("username");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Invalid UserName");
        }
        else {

            try {
                // Create User.
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                String newPassword2 = req.getParameter("password2");
                System.out.println(newPassword2);

                if (!password.equals(newPassword2)) {
                    messages.put("success", "Passwords do not match");
                } else {
                    User user = new User(userName, email, password);
                    user = userDao.createUser(user);
                    messages.put("success", "Successfully created " + userName);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        }

        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
    }
}
