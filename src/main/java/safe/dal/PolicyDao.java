package safe.dal;

import safe.model.Policy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Policy DAO. Access policy data to our MySQL database
 */
public class PolicyDao {

	protected ConnectionManager connectionManager;
	
	private static PolicyDao instance = null;
	protected PolicyDao() {
		connectionManager = new ConnectionManager();
	}

	public static PolicyDao getInstance() {
		if(instance == null) {
			instance = new PolicyDao();
		}
		return instance;	
	}

	/**
	 * Get a policy by policy id
	 * @param policyId a given policy id
	 * @return a Policy object
	 * @throws SQLException
	 */
	public Policy getPolicyById(Integer policyId) throws SQLException {
		String selectPolicy = "SELECT PolicyId, StateCode, County, FipsCode," +
				"Active, TotalPhases, Content, PolicyDate, Resource " +
				"FROM Policy " +
				"WHERE PolicyId=? ;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;

		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPolicy);
			selectStmt.setInt(1, policyId);
			results = selectStmt.executeQuery();

			if (results.next()) {
				return buildPolicy(results);
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
		return null;
	}

	/**
	 * Get a list policies by county and state code
	 * @param county a given county
	 * @param stateCode a given state
	 * @return a list of Policies in that county and state
	 * @throws SQLException
	 */
	public List<Policy> getPolicyByCountyState(String county, String stateCode) throws SQLException {
		String selectPolicy = "SELECT PolicyId, StateCode, County, FipsCode," +
				"Active, TotalPhases, Content, PolicyDate, Resource " +
				"FROM Policy " +
				"WHERE County=? AND StateCode=? ;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		List<Policy> policies = new ArrayList<>();

		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPolicy);
			selectStmt.setString(1, county);
			selectStmt.setString(2, stateCode);
			results = selectStmt.executeQuery();

			while (results.next()) {
				Policy policy = buildPolicy(results);
				policies.add(policy);
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
		return policies;
	}

	/**
	 * Get a list policies by county fips
	 * @param fips a given county fips
	 * @return a list of Policies in that county
	 * @throws SQLException
	 */
	public List<Policy> getPolicyByCountyFips(Integer fips) throws SQLException {
		String selectPolicy = "SELECT PolicyId, StateCode, County, FipsCode," +
				"Active, TotalPhases, Content, PolicyDate, Resource " +
				"FROM Policy " +
				"WHERE FipsCode=?;";

		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		List<Policy> policies = new ArrayList<>();

		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPolicy);
			selectStmt.setInt(1, fips);
			results = selectStmt.executeQuery();

			while (results.next()) {
				Policy policy = buildPolicy(results);
				policies.add(policy);
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
		return policies;
	}


	/**
	 * Build an instance of Policy
	 * @param results set of results from MySQL
	 * @return a new Policy instance
	 * @throws SQLException
	 */
	private Policy buildPolicy(ResultSet results) throws SQLException {
		Integer resultPolicyId = results.getInt("PolicyId");
		String stateCode = results.getString("StateCode");
		String county = results.getString("County");
		Integer fips = results.getInt("FipsCode");
		String active = results.getString("Active");
		Integer totalPhases = results.getInt("TotalPhases");
		String content = results.getString("Content");
		Date date = results.getDate("PolicyDate");
		String resource = results.getString("Resource");

		Policy policy = new Policy(resultPolicyId, stateCode, county, fips, active, totalPhases, content, date, resource);
		return policy;
	}

}
