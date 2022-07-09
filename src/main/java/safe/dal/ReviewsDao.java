package safe.dal;

import safe.model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object (DAO) class to interact with the underlying
 */
public class ReviewsDao {
    protected ConnectionManager connectionManager;
    // Single pattern: instantiation is limited to one object.
    private static ReviewsDao instance = null;
    protected ReviewsDao() {
        connectionManager = new ConnectionManager();
    }
    public static ReviewsDao getInstance() {
        if(instance == null) {
            instance = new ReviewsDao();
        }
        return instance;
    }

    public Review createReviews(Review review) throws SQLException {
        String insertReviews = "INSERT INTO Reviews(UserName, Created, UserReview, Rating, ProfileId) VALUES(?, ?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;

        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertReviews, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, review.getUserName());
            insertStmt.setTimestamp(2, new Timestamp(review.getCreated().getTime()));
            insertStmt.setString(3, (review).getUserReview());
            insertStmt.setDouble(4, review.getRating());
            insertStmt.setInt(5, review.getProfileId());
            insertStmt.executeUpdate();

            resultKey = insertStmt.getGeneratedKeys();
            int reviewId = -1;

            if (resultKey.next()) {
                reviewId = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key");
            }
            review.setReviewId(reviewId);;
            return review;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }

    public List<Review> getReviewByStateName(String stateName) throws SQLException {

        List<Review> reviewList = new ArrayList<Review>();
        String selectLocation = "SELECT Reviews.* " +
                "FROM Reviews INNER JOIN StateProfile" +
                "ON Reviews.ProfileId = StateProfile.stateFIPS " +
                "WHERE StateProfile.stateName = ?\n;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectLocation);
            selectStmt.setString(1, stateName);
            results = selectStmt.executeQuery();

            while (results.next()) {
                Integer resultReviewId = results.getInt("ReviewId");
                String resultUserName = results.getString("UserName");
                Timestamp resultCreate = new Timestamp(results.getTimestamp("Created").getTime());
                String resultUserReview = results.getString("UserReview");
                Double resultRating = results.getDouble("Rating");
                Integer resultProfileId = results.getInt("ProfileId");
                Review resultReview = new Review(resultReviewId, resultUserName,resultCreate,resultUserReview,resultRating,resultProfileId);
                reviewList.add(resultReview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(selectStmt != null) {
                selectStmt.close();
            }
            if(results != null) {
                results.close();
            }
        }
        return reviewList;
    }

    public List<Review> getReviewByProfileId(Integer profileId) throws SQLException {

        List<Review> reviewList = new ArrayList<Review>();
        String selectLocation = "SELECT ReviewId, UserName, Created, UserReview, Rating, ProfileId " +
                "FROM Reviews " +
                "WHERE ProfileId = ?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectLocation);
            selectStmt.setInt(1, profileId);
            results = selectStmt.executeQuery();

            while (results.next()) {
                Integer resultReviewId = results.getInt("ReviewId");
                String resultUserName = results.getString("UserName");
                Timestamp resultCreate = new Timestamp(results.getTimestamp("Created").getTime());
                String resultUserReview = results.getString("UserReview");
                Double resultRating = results.getDouble("Rating");
                Integer resultProfileId = results.getInt("ProfileId");
                Review resultReview = new Review(resultReviewId, resultUserName,resultCreate,resultUserReview,resultRating,resultProfileId);
                reviewList.add(resultReview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(selectStmt != null) {
                selectStmt.close();
            }
            if(results != null) {
                results.close();
            }
        }
        return reviewList;
    }

    public List<Review> getReviewByUserName(String userName) throws SQLException {


        List<Review> reviewList = new ArrayList<Review>();
        String selectLocation = "SELECT * FROM Profile " +
                "WHERE UserName = ?\n;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectLocation);
            selectStmt.setString(1, userName);
            results = selectStmt.executeQuery();

            while (results.next()) {
                Integer resultReviewId = results.getInt("ReviewId");
                String resultUserName = results.getString("UserName");
                Timestamp resultCreate = new Timestamp(results.getTimestamp("Created").getTime());
                String resultUserReview = results.getString("UserReview");
                Double resultRating = results.getDouble("Rating");
                Integer resultProfileId = results.getInt("ProfileId");
                Review resultReview = new Review(resultReviewId, resultUserName,resultCreate,resultUserReview,resultRating,resultProfileId);
                reviewList.add(resultReview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(selectStmt != null) {
                selectStmt.close();
            }
            if(results != null) {
                results.close();
            }
        }
        return reviewList;
    }

}
