package safe.servlet;


import safe.dal.UserDao;
import safe.dal.WishListDao;
import safe.model.User;
import safe.model.WishList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/wishlistdelete")
public class WishListDelete extends HttpServlet {

    protected WishListDao wishListDao;

    @Override
    public void init() throws ServletException {
        wishListDao = WishListDao.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        messages.put("title", "Delete Wishlist");
        req.getRequestDispatcher("/WishListDelete.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        String username = req.getParameter("username");
            try {
                WishListDao wishListDao = WishListDao.getInstance();
                WishList wishList = wishListDao.deleteWishListByUsername(username);
                // Update the message.
                if (wishList == null) {
                    messages.put("title", "Successfully deleted wishlist " + username);
                    //messages.put("disableSubmit", "true");
                } else {
                    messages.put("title", "Failed to delete wishlist for " + username);
                   // messages.put("disableSubmit", "false");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }

        req.getRequestDispatcher("/WishListDelete.jsp").forward(req, resp);
    }
}
