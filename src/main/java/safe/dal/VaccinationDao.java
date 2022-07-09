package safe.dal;

import safe.model.*;
import java.math.BigInteger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VaccinationDao {
	
	// Only has 2 attributes: 
	protected ConnectionManager connectionManager;
	private static VaccinationDao instance = null;
	
	// Constructor
	protected VaccinationDao() {
		connectionManager = new ConnectionManager();
	}
	
	// Method returns an instance of class 'Vaccination'
	public static VaccinationDao getInstance() {
		if(instance == null) {
			instance = new VaccinationDao();
		}
		return instance;
	}
	
	/**
	 * Get the Vaccination record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Vaccination instance.
	 * Note that we use VaccinationDao to retrieve the referenced Vaccination instance.
	 * Get vaccination data by 'vaccinationId'.
	 * SELECT all attributes from class 'Vaccination'.	
	 * FROM class 'Vaccination'
	 * WHERE 'vaccinationId' is specified.
	*/
	public Vaccination getVaccinationInformationByVacId(Integer vaccinationId) throws SQLException {
		
		String selectVaccinationInfoById =
			"SELECT vaccinationId, countyName, countyFIPS, stateCode, date, vaccinationSeriesCompletePct,vaccinationSeriesCompletePop,completenessPct " +
			"FROM Vaccination " +
			"WHERE VaccinationId=?;";
		
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectVaccinationInfoById);
			selectStmt.setInt(1, vaccinationId);
			results = selectStmt.executeQuery();
			
			// No parent class instances
			
			if(results.next()) {
				Integer resultVaccinationId = results.getInt("VaccinationId");
				String resultCountyName = results.getString("CountyName");
				Integer resultCountyFIPS = results.getInt("CountyFIPS");
				String resultStateCode = results.getString("StateCode");
				Date resultDate =  new Date(results.getTimestamp("Date").getTime());
				Double resultVaccinationSeriesCompletePct = results.getDouble("VaccinationSeriesCompletePct");
				BigInteger resultVaccinationSeriesCompletePop = BigInteger.valueOf(results.getInt("VaccinationSeriesCompletePop"));
				Double completenessPct = results.getDouble("CompletenessPct");

				Vaccination vaccinationById = new Vaccination(resultVaccinationId, resultCountyName, resultCountyFIPS,
						resultStateCode, resultDate, resultVaccinationSeriesCompletePct, resultVaccinationSeriesCompletePop,
					completenessPct);
				System.out.println(vaccinationId);
				return vaccinationById;
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
			return null ;
		}

	public Vaccination getVaccinationInformationByCountyFips(Integer fips) throws SQLException {

		String selectVaccination =
				"SELECT vaccinationId, countyName, countyFIPS, stateCode, date, vaccinationSeriesCompletePct,vaccinationSeriesCompletePop,completenessPct " +
						"FROM Vaccination " +
						"WHERE countyFIPS=?;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;

		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectVaccination);
			selectStmt.setInt(1, fips);
			results = selectStmt.executeQuery();

			// No parent class instances

			if(results.next()) {
				Integer resultVaccinationId = results.getInt("VaccinationId");
				String resultCountyName = results.getString("CountyName");
				Integer resultCountyFIPS = results.getInt("CountyFIPS");
				String resultStateCode = results.getString("StateCode");
				Date resultDate =  new Date(results.getTimestamp("Date").getTime());
				Double resultVaccinationSeriesCompletePct = results.getDouble("VaccinationSeriesCompletePct");
				BigInteger resultVaccinationSeriesCompletePop = BigInteger.valueOf(results.getInt("VaccinationSeriesCompletePop"));
				Double completenessPct = results.getDouble("CompletenessPct");

				Vaccination vaccinationByFips = new Vaccination(resultVaccinationId, resultCountyName, resultCountyFIPS,
						resultStateCode, resultDate, resultVaccinationSeriesCompletePct, resultVaccinationSeriesCompletePop,
						completenessPct);

				return vaccinationByFips;
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
		return null ;
	}
}

