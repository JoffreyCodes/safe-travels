package safe.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import safe.model.NationalProfile;
import safe.model.Profile;

public class NationalProfileDao extends ProfileDao {
  protected ConnectionManager connectionManager;
  private static NationalProfileDao instance = null;
  protected NationalProfileDao() {
    connectionManager = new ConnectionManager();
  }

  public static NationalProfileDao getInstance() {
    if(instance == null) {
      instance = new NationalProfileDao();
    }
    return instance;
  }

  /**
   * get CountyProfile by its ID
   * @param ProfileId - the Nation ID
   * @return a new NationalProfile
   * @throws SQLException
   */
  public NationalProfile getNationById(Integer ProfileId) throws SQLException {
    String selectNationProfile =
        "SELECT ProfileId, Name, Date, CovidCases, CovidDeaths " +
            "FROM countyprofile INNER JOIN profile USING (ProfileId) " +
            "WHERE ProfileId = ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet result = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectNationProfile);
      selectStmt.setInt(1, ProfileId);

      result = selectStmt.executeQuery();
      if (result.next()) {
        Profile profile = super.buildProfile(result);
        String name = result.getString("Name");
        NationalProfile nationalProfile = new NationalProfile(profile.getProfileId(), profile.getDate(),
            profile.getCovidCases(), profile.getCovidDeaths(), name);

        return nationalProfile;
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
      if(result != null) {
        result.close();
      }
    }
    return null;

  }


}
