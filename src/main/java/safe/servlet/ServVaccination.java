package safe.servlet;

import safe.dal.*;
import safe.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/vaccination")
public class ServVaccination extends HttpServlet {
	
	protected VaccinationDao vaccinationDao;
	protected CountyProfileDao countyProfileDao;
	
	@Override
	public void init() throws ServletException{
		vaccinationDao = VaccinationDao.getInstance();
		countyProfileDao = CountyProfileDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<>();
		req.setAttribute("messages", messages);
		Vaccination vaccination = null;
		
		// Retrieve vaccination data depending on valid vaccinationId
		Integer fips = Integer.valueOf(req.getParameter("fips"));

		try {
			if (fips != null) {
				vaccination = vaccinationDao.getVaccinationInformationByCountyFips(fips);
				CountyProfile countyProfile = countyProfileDao.getCountyByCountyFIPS(fips);
				messages.put("title", "Vaccination information by fips" + fips);
				messages.put("title", "Mask usage for " + countyProfile.getCountyName());
				messages.put("countyName", countyProfile.getCountyName());
			}
				else {
					messages.put("title", "Invalid County Fips");
				}
				
		} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			

		req.setAttribute("vaccination", vaccination);
		req.getRequestDispatcher("/Vaccination.jsp").forward(req, resp);
		
	}
}
