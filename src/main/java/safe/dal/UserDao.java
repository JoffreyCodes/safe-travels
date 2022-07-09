package safe.dal;

import safe.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO class to interact with the User's table in our MySQl database. This has
 * all CRUD operations
 */
public class UserDao {
    protected ConnectionManager connectionManager;

    private static UserDao instance = null;
    protected UserDao() {
        connectionManager = new ConnectionManager();
    }
    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    /**
     * Creates a User and adds it to our database
     * @param user - new user to add
     * @return the created user
     * @throws SQLException
     */
    public User createUser(User user) throws SQLException {
        String insertUser = "INSERT INTO Users(UserName, Email, Password) VALUES(?, ?, ?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;

        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertUser);
            insertStmt.setString(1, user.getUserName());
            insertStmt.setString(2, user.getEmail());
            insertStmt.setString(3, user.getPassword());
            insertStmt.executeUpdate();
            return user;
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

    /**
     * Get a user by username
     * @param userName - a given username
     * @return a user with the associated username
     * @throws SQLException
     */
    public User getUserByUserName(String userName) throws SQLException {
        String selectUser =
                "SELECT Users.UserName AS UserName, Email, Password FROM Users WHERE UserName = ?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet result = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectUser);
            selectStmt.setString(1, userName);
            result = selectStmt.executeQuery();

            if (result.next()) {
                String resultUserName = result.getString("UserName");
                String email = result.getString("Email");
                String password = result.getString("Password");

                User user = new User(resultUserName, email, password);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (selectStmt != null) {
                selectStmt.close();
            }
            if (result != null) {
                result.close();
            }
        }
        return null;
    }

    /**
     * Get a user by email
     * @param email - a given username
     * @return a user with the associated username
     * @throws SQLException
     */
    public User getUserByEmail(String email) throws SQLException {
        String selectUser =
                "SELECT Users.UserName AS UserName, Email" +
                        "FROM Users" +
                        "WHERE Email = ?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet result = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectUser);
            selectStmt.setString(1, email);
            result = selectStmt.executeQuery();

            if (result.next()) {
                String resultUserName = result.getString("UserName");
                String resultEmail = result.getString("Email");
                String password = result.getString("Password");

                User user = new User(resultUserName, resultEmail, password);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (selectStmt != null) {
                selectStmt.close();
            }
            if (result != null) {
                result.close();
            }
        }
        return null;
    }



    /**
     * Update the email of the User instance
     * @param user - user to update
     * @param newEmail - new email to update
     * @return updated user
     * @throws SQLException
     */
    public User updateEmail(User user, String newEmail) throws SQLException {
        String updateEmail = "UPDATE Users SET Email=? WHERE UserName=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;

        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateEmail);
            updateStmt.setString(1, newEmail);
            updateStmt.setString(2, user.getUserName());
            updateStmt.executeUpdate();

            user.setEmail(newEmail);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (updateStmt != null) {
                updateStmt.close();
            }
        }
    }

    /**
     * Update the password of the User instance
     * @param user - user to update
     * @param newPassword - new email to update
     * @return updated user
     * @throws SQLException
     */
    public User updatePassword(User user, String newPassword) throws SQLException {
        String updateEmail = "UPDATE Users SET Password=? WHERE UserName=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;

        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateEmail);
            updateStmt.setString(1, newPassword);
            updateStmt.setString(2, user.getUserName());
            updateStmt.executeUpdate();

            user.setPassword(newPassword);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (updateStmt != null) {
                updateStmt.close();
            }
        }
    }

    /**
     * Delete the User instance
     * @param user - user to delete
     * @return null
     * @throws SQLException
     */
    public User delete(User user) throws SQLException {
        String deleteUser = "DELETE FROM Users WHERE UserName =?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;

        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteUser);
            deleteStmt.setString(1, user.getUserName());
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
