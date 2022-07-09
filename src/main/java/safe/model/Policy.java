package safe.model;

import java.util.Date;


/**
 * This class represents a Policy object.
 */
public class Policy {

	protected int policyId;
	protected String stateCode;
	protected String county;
	protected int fipsCode;
	protected String active;
	protected int totalPhases;
	protected String content;
	protected Date policyDate;
	protected String resource;

	/**
	 * Constructs a Policy object with the following parameters.
	 * @param policyId - id for Policy
	 * @param stateCode - where the Policy is taken place at the given state
	 * @param county - where the Policy is taken place at the given county
	 * @param fipsCode - FIPS code of either state/county
	 * @param active - start/stop phase of policy
	 * @param totalPhases - total phases that the policy has
	 * @param content - policy information
	 * @param policyDate - date of when the Policy is effective
	 * @param resource - source
	 */
	public Policy(int policyId, String stateCode, String county, int fipsCode, String active, int totalPhases, String content, Date policyDate, String resource) {
		this.policyId = policyId;
		this.stateCode = stateCode;
		this.county = county;
		this.fipsCode = fipsCode;
		this.active = active;
		this.totalPhases = totalPhases;
		this.content = content;
		this.policyDate = policyDate;
		this.resource = resource;
	}

	/** Getters and Setters */
	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getFipsCode() {
		return fipsCode;
	}

	public void setFipsCode(int fipsCode) {
		this.fipsCode = fipsCode;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public int getTotalPhases() {
		return totalPhases;
	}

	public void setTotalPhases(int totalPhases) {
		this.totalPhases = totalPhases;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPolicyDate() {
		return policyDate;
	}

	public void setPolicyDate(Date policyDate) {
		this.policyDate = policyDate;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}

