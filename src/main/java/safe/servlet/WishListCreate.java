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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/wishlistcreate")
public class WishListCreate extends HttpServlet {

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
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/WishListCreate.jsp").forward(req, resp);
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
        String state = req.getParameter("state");
        //String city = req.getParameter("city");
        String county = req.getParameter("county");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Invalid UserName");
        }
        else {
            try {
                StateProfileDao stateProfileDao = StateProfileDao.getInstance();
                UserDao userDao = UserDao.getInstance();
                StateProfile stateProfile = stateProfileDao.getStateProfileByName(state);
                User user = userDao.getUserByUserName(userName);
                CountyProfileDao countyProfileDao = CountyProfileDao.getInstance();
                CountyProfile countyProfile = countyProfileDao.getCountyByCountyName(county);
                WishList wishList = new WishList(user, null, stateProfile, countyProfile);
                wishList = wishListDao.createWishList(wishList);
                messages.put("success", "Successfully created wishlist for user" + userName);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        }

        req.getRequestDispatcher("/WishListCreate.jsp").forward(req, resp);
    }
}
