package safe.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import safe.dal.ReviewsDao;

import safe.dal.StateProfileDao;
import safe.model.Review;
import safe.model.StateProfile;

@WebServlet("/statereview")
public class StateReviewsRetrieve extends HttpServlet {

	protected ReviewsDao reviewDao;

    @Override
    public void init() throws ServletException {
        reviewDao = ReviewsDao.getInstance();
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
        Integer profileId = Integer.valueOf(req.getParameter("stateProfileId"));
        List<Review> reviewList = new ArrayList<>();

        if (profileId == null) {
          messages.put("success", "Please enter a valid profile id.");
        } else {
          // Retrieve stateName data, and store as a message.
          try {
			 reviewList = reviewDao.getReviewByProfileId(profileId);
              StateProfileDao stateProfileDao = StateProfileDao.getInstance();
              StateProfile state = stateProfileDao.getStateProfileById(profileId);

              messages.put("success", "Displaying results for state" + state.getStateName());
              // Save the previous search term, so it can be used as the default
              // in the input box when rendering FindUsers.jsp.
              messages.put("previous stateName", state.getStateName());
          } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e);
          }

        }
        req.setAttribute("reviewList", reviewList);
        req.getRequestDispatcher("/StateReviewRetrieve.jsp").forward(req, resp);
      }
    }

