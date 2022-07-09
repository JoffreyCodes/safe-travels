package safe.dal;

import safe.model.CityInformation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityInformationDao {
  protected ConnectionManager connectionManager;
  private static CityInformationDao instance = null;
  protected CityInformationDao() {
    connectionManager = new ConnectionManager();
  }
  public static CityInformationDao getInstance() {
    if(instance == null) {
      instance = new CityInformationDao();
    }
    return instance;
  }

  public List<CityInformation> getCityInformationByString(String location) throws SQLException {
    List<CityInformation> cityLocations = new ArrayList<CityInformation>();
    String selectCityLocations =
      "select locTable.CityId, locTable.CityName, locTable.CountyName, locTable.StateName, locTable.StateCode, ProfileId as CountyProfileId, StateProfileId\n" +
        "        from countyprofile join (\n" +
        "            select ID as CityId, CityName, StateCode, StateName, CountyName, CountyFIPS\n" +
        "            from cityinformation\n" +
        "            where CityName like ? or CountyName like ? or StateCode like ? or StateName like ? \n" +
        "        ) as locTable\n" +
        "        on locTable.CountyFIPS = countyprofile.CountyFIPS;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCityLocations);
      selectStmt.setString(1, location);
      selectStmt.setString(2, location);
      selectStmt.setString(3, location);
      selectStmt.setString(4, location);


      results = selectStmt.executeQuery();
      while (results.next()) {
        Integer cityId = results.getInt("CityId");
        String cityName = results.getString("CityName");
        String countyName = results.getString("CountyName");
        String stateName = results.getString("StateName");
        String stateCode = results.getString("StateCode");
        Integer countyProfiledId = results.getInt("CountyProfileId");
        Integer stateProfiledId = results.getInt("StateProfileId");

        CityInformation cityLocation = new CityInformation(cityId, cityName, countyName, stateName, stateCode,
          countyProfiledId, stateProfiledId);
        cityLocations.add(cityLocation);
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
    return cityLocations;
  }
}
