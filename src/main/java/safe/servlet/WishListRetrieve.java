package safe.servlet;

import safe.dal.CountyProfileDao;
import safe.dal.StateProfileDao;
import safe.dal.UserDao;
import safe.dal.WishListDao;
import safe.model.CountyProfile;
import safe.model.StateProfile;
import safe.model.User;
import safe.model.WishList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/wishlistretrieve")
public class WishListRetrieve extends HttpServlet {

    protected WishListDao wishListDao;

    @Override
    public void init() throws ServletException {
        wishListDao = WishListDao.getInstance();
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
        req.getRequestDispatcher("/WishListDelete.jsp").forward(req, resp);
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
        //String city = req.getParameter("city");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Invalid UserName");
        }
        else {
            try {
                List<WishList> wishListByUser = new ArrayList<>();
                WishListDao wishListDao = WishListDao.getInstance();
                wishListByUser = wishListDao.getWishListByUserName(userName);
                if(wishListByUser == null){
                    messages.put("Title", "No wishlist for this user");
                    //req.setAttribute("messages", messages);
                    req.getRequestDispatcher("/WishListDelete.jsp").forward(req, resp);
                }else {
                    req.setAttribute("wishListByUser", wishListByUser);
                    messages.put("success", "Successfully got wishlist for user" + userName);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        }
        req.getRequestDispatcher("/WishListRetrieve.jsp").forward(req, resp);

    }
}
