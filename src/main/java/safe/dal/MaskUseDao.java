package safe.dal;

import safe.model.MaskUse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaskUseDao {
  protected ConnectionManager connectionManager;
  private static MaskUseDao instance = null;

  protected MaskUseDao() {
    connectionManager = new ConnectionManager();
  }

  public static MaskUseDao getInstance() {
    if (instance == null) {
      instance = new MaskUseDao();
    }
    return instance;
  }

  public List<MaskUse> getMaskUseByMaskUseId(Integer fips) throws SQLException {
    String selectMaskUseByCountyFIPS =
      "SELECT MaskUseID, CountyFIPS, NEVER, RARELY, SOMETIMES, FREQUENTLY, ALWAYS\n" +
        "FROM maskuse\n" +
        "WHERE CountyFIPS = ?\n";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    List<MaskUse> maskUseList = new ArrayList<>();

    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectMaskUseByCountyFIPS);
      selectStmt.setInt(1, fips);
      results = selectStmt.executeQuery();

      if (results.next()) {
        Integer MaskUseId = results.getInt("MaskUseId");
        Integer CountyFIPS = results.getInt("countyFIPS");
        Double NEVER = results.getDouble("NEVER");
        Double RARELY = results.getDouble("RARELY");
        Double SOMETIMES = results.getDouble("SOMETIMES");
        Double FREQUENTLY = results.getDouble("FREQUENTLY");
        Double ALWAYS = results.getDouble("ALWAYS");

        maskUseList.add(new MaskUse(MaskUseId, CountyFIPS, NEVER, RARELY, SOMETIMES, FREQUENTLY, ALWAYS));
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
      if (results != null) {
        results.close();
      }
    }
    return maskUseList;
  }
}
