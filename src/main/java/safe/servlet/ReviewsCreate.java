package safe.servlet;

import safe.dal.ReviewsDao;
import safe.dal.StateProfileDao;
import safe.dal.UserDao;
import safe.model.Review;
import safe.model.StateProfile;
import safe.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet("/reviewscreate")
public class ReviewsCreate extends HttpServlet {

    protected ReviewsDao reviewDao;
    protected StateProfileDao stateProfileDao;

    @Override
    public void init() throws ServletException {
        reviewDao = ReviewsDao.getInstance();
        stateProfileDao = StateProfileDao.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.
        List<StateProfile> stateProfileList = new ArrayList<>();
        try {
            stateProfileList = stateProfileDao.getStateProfiles();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("stateProfileList", stateProfileList);
        req.getRequestDispatcher("/ReviewsCreate.jsp").forward(req, resp);
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
        // Map for storing messages.\
        Date date = new Date();
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);


        // Retrieve and validate name.
        String userName = req.getParameter("username");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Invalid UserName");
        }
        else {

            try {
                String userName1 = req.getParameter("username");
                Timestamp created = new Timestamp(date.getTime());
                String userReview = req.getParameter("review");
                Double rating = Double.valueOf(req.getParameter("rating"));

                String state = req.getParameter("stateToReview");
                StateProfile stateProfile = stateProfileDao.getStateProfileByName(state);
                int profileId = stateProfile.getProfileId();

                Review review = new Review(userName1, created, userReview, rating, profileId);
                review = reviewDao.createReviews(review);
                messages.put("success", "Successfully created " + review);

            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        }
        req.getRequestDispatcher("/ReviewsCreate.jsp").forward(req, resp);
    }
}
