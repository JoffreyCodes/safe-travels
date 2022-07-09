package safe.dal;
import safe.model.USTravel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class USTravelDao {
    protected ConnectionManager connectionManager;

    private static USTravelDao instance = null;
    protected USTravelDao() {
        connectionManager = new ConnectionManager();
    }
    public static USTravelDao getInstance() {
        if (instance == null) {
            instance = new USTravelDao();
        }
        return instance;
    }

    public USTravel getTravelStatisticsByStateName(String inputString) throws SQLException {
        String selectTravelStatsByName = "SELECT USTravel.TravelID as TravelID, USTravel.StateFIPS as StateFIPS," +
                " USTravel.ProfileId as ProfileId, USTravel.USPopStayingAtHome  USPopStayingAtHome," +
                "USTravel.USPopNotStayingAtHome as USPopNotStayingAtHome, USTravel.PercentTakingTrips as PercentTakingTrips," +
                "StateProfile.StateName as StateName FROM USTravel INNER JOIN StateProfile on USTravel.ProfileId = StateProfile.ProfileId" +
                " WHERE StateProfile.StateName = ? OR StateProfile.StateCode = ?;";
        System.out.println(selectTravelStatsByName);
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet result = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectTravelStatsByName);
            selectStmt.setString(1, inputString);
            selectStmt.setString(2, inputString);

            result = selectStmt.executeQuery();


            if (result.next()) {
                Integer resultTravelID = result.getInt("TravelID");
                Integer resultStateFIPS = result.getInt("StateFIPS");
                Integer resultProfileId = result.getInt("ProfileId");
                Long resultUSPopStayingAtHome = result.getLong("USPopStayingAtHome");
                Long resultUSPopNotStayingAtHome = result.getLong("USPopNotStayingAtHome");
                Double resultPercentTakingTrips = result.getDouble("PercentTakingTrips");
                String resultStateName = result.getString("StateName");

                USTravel usTravelByState = new USTravel(resultTravelID, resultStateFIPS, resultProfileId,
                        resultUSPopStayingAtHome, resultUSPopNotStayingAtHome,resultPercentTakingTrips,
                        resultStateName);
                return usTravelByState;
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
}

