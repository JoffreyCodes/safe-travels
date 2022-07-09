package safe.model;

import java.util.Date;
import java.math.BigInteger;

// Has-a Relationship (does not extend CountyProfile).
public class Vaccination{ 
	
	protected Integer vaccinationId;
	protected String countyName;
	protected Integer countyFIPS;
	protected String stateCode;
	protected Date date;
	protected Double vaccinationSeriesCompletePct;
	protected BigInteger vaccinationSeriesCompletePop;
	protected Double completenessPct;
	
	// No super() class.
	public Vaccination(Integer vaccinationId, String countyName, Integer countyFIPS, String stateCode, Date date,
			Double vaccinationSeriesCompletePct, BigInteger vaccinationSeriesCompletePop, Double completenessPct) {
		
		this.vaccinationId = vaccinationId; // surrogate key.
		this.countyName = countyName;
		this.countyFIPS = countyFIPS;
		this.stateCode = stateCode;
		this.date = date;
		this.vaccinationSeriesCompletePct = vaccinationSeriesCompletePct;
		this.vaccinationSeriesCompletePop = vaccinationSeriesCompletePop;
		this.completenessPct = completenessPct;		
	}
	
	public Integer getVaccinationId() {
		return vaccinationId;
	}
	
	public String getCountyName() {
		return countyName;
	}
	
	public Integer getCountyFIPS() {
		return countyFIPS;
	}
	
	public String getStateCode() {
		return stateCode;
	}
	
	public Date getdate() {
		return date;
	}

	public Double getVaccinationSeriesCompletePct() {
		return vaccinationSeriesCompletePct;
	}
	
	public BigInteger getVaccinationSeriesCompletePop() {
		return vaccinationSeriesCompletePop;
	}
	
	public Double getCompletenessPct() {
		return completenessPct;
	}
}
