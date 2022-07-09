package safe.dal;

import safe.model.StateProfile;
import safe.model.User;
import safe.model.WishList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WishListDao {
    protected ConnectionManager connectionManager;

    private static WishListDao instance = null;
    protected WishListDao() {
        connectionManager = new ConnectionManager();
    }
    public static WishListDao getInstance() {
        if (instance == null) {
            instance = new WishListDao();
        }
        return instance;
    }

    /**
     * Creates a User and adds it to our database
     * @param wishlist - new wishlist to add
     * @return the created user
     * @throws SQLException
     */
    public WishList createWishList(WishList wishlist) throws SQLException {
        String insertWishList = "INSERT INTO WishList(UserName, CityProfileId, StateProfileId," +
                "CountyProfileId) VALUES(?, ?, ?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        //need a getStateProfileByI
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertWishList,
                    Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, wishlist.getUser().getUserName());
            insertStmt.setNull(2, Types.INTEGER);
            if(wishlist.getStateProfile() == null){
                insertStmt.setNull(3, Types.INTEGER);
            }else {
                insertStmt.setInt(3, wishlist.getStateProfile().getProfileId());
            }
            if(wishlist.getCountyProfile() == null){
                insertStmt.setNull(4, Types.INTEGER);
            }else {
                insertStmt.setInt(4, wishlist.getCountyProfile().getProfileId());
            }

            insertStmt.executeUpdate();
            resultKey = insertStmt.getGeneratedKeys();
            int wishListId = -1;
            if(resultKey.next()) {
                wishListId = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            wishlist.setWishListID(wishListId);
            return wishlist;
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

    public List<WishList> getWishListByUserName(String username) throws SQLException {
        List<WishList> wishListUser = new ArrayList<WishList>();

        String selectWishListUser = "SELECT * FROM WishList WHERE UserName = ?";

        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectWishListUser);
            selectStmt.setString(1, username);

            results = selectStmt.executeQuery();
            UserDao userDao = UserDao.getInstance();
            StateProfileDao stateProfileDao = StateProfileDao.getInstance();
            CountyProfileDao countyProfileDao = CountyProfileDao.getInstance();
            while (results.next()) {
                Integer wishID = results.getInt("WishId");
                String userName = results.getString("UserName");
                Integer cityProfileId = results.getInt("CityProfileId");
                Integer stateProfileID = results.getInt("StateProfileId");
                Integer countyProfileID = results.getInt("CountyProfileId");
                WishList wishList = new WishList(wishID, userDao.getUserByUserName(userName), null, stateProfileDao.getStateProfileById(stateProfileID),
                       countyProfileDao.getCountyProfileByProfileId(countyProfileID));
                wishListUser.add(wishList);
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
        return wishListUser;
    }

    public WishList deleteWishListByUsername(String username) throws SQLException {
        String deleteWishList = "DELETE FROM WishList WHERE UserName =?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;

        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteWishList);
            deleteStmt.setString(1, username);
            deleteStmt.executeUpdate();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (deleteStmt != null) {
                deleteStmt.close();
            }
        }
    }
    }
