package safe.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import safe.model.StateProfile;
import safe.model.User;

import javax.swing.plaf.nimbus.State;

/**
 * StateProfile DAO
 */
public class StateProfileDao extends ProfileDao {
  private static StateProfileDao instance = null;
  protected StateProfileDao() {super(); }
  public static StateProfileDao getInstance() {
    if (instance == null) {
      instance = new StateProfileDao();
    }
    return instance;
  }

  /**
   * Gets a list of all state profiles
   * @return List of all state profiles
   * @throws SQLException
   */
  public List<StateProfile> getStateProfiles() throws SQLException {

    List<StateProfile> stateProfiles = new ArrayList<StateProfile>();

    String selectLocation =
        "SELECT ProfileId, Date, StateFIPS, StateName, StateCode, SafetyRating, CovidCases, CovidDeaths, NumCounties " +
            "FROM Profile " +
            "INNER JOIN StateProfile USING (ProfileId);";

    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectLocation);
      results = selectStmt.executeQuery();
      while (results.next()) {
        stateProfiles.add(buildStateProfile(results));
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
    return stateProfiles;
  }

  /**
   * Gets a StateProfile from its name
   * @param stateName - name of state profile
   * @return a StateProfile object
   * @throws SQLException
   */
  public StateProfile getStateProfileByName(String stateName) throws SQLException {
    String selectState =
        "SELECT ProfileId, Date, StateFIPS, StateName, StateCode, SafetyRating, CovidCases, CovidDeaths, NumCounties " +
            "FROM Profile " +
            "INNER JOIN StateProfile USING (ProfileId) " +
            "WHERE StateName=? OR StateCode=?;";

    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectState);
      selectStmt.setString(1, stateName);
      selectStmt.setString(2, stateName);
      results = selectStmt.executeQuery();
      if (results.next()) {
        return buildStateProfile(results);
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
    return null;
  }

  /**
   * Gets a StateProfile by its ID
   * @param stateId - ID of StateProfile
   * @return a StateProfile object
   * @throws SQLException
   */
  public StateProfile getStateProfileById(Integer stateId) throws SQLException {
    String selectState =
        "SELECT ProfileId, Date, StateFIPS, StateName, StateCode, SafetyRating, CovidCases, CovidDeaths, NumCounties " +
            "FROM Profile " +
            "INNER JOIN StateProfile USING (ProfileId) " +
            "WHERE ProfileId=?;";

    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectState);
      selectStmt.setInt(1, stateId);
      results = selectStmt.executeQuery();
      if (results.next()) {
        return buildStateProfile(results);
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
    return null;
  }

  /**
   * builds a StateProfile from the ResultSet
   * @param results - ResultSet from MySQL
   * @return a StateProfile object
   * @throws SQLException
   */
  private StateProfile buildStateProfile(ResultSet results) throws SQLException {
    Integer profileId = results.getInt("ProfileId");
    Date date = new Date(results.getTimestamp("Date").getTime());
    Integer covidCases = results.getInt("CovidCases");
    Integer covidDeaths = results.getInt("covidDeaths");
    Integer stateFIPS = results.getInt("StateFIPS");
    String stateName = results.getString("StateName");
    String stateCode = results.getString("StateCode");
    Integer numCounties = results.getInt("NumCounties");
    Double safetyRating = results.getDouble("SafetyRating");

    StateProfile stateProfile = new StateProfile(profileId, date, covidCases, covidDeaths,
        stateFIPS, stateCode, stateName, numCounties, safetyRating);

    return stateProfile;
  }

}
