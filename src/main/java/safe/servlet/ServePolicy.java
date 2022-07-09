package safe.servlet;

import safe.dal.CountyProfileDao;
import safe.dal.PolicyDao;
import safe.model.CountyProfile;
import safe.model.Policy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet for Policy
 */
@WebServlet("/policy")
public class ServePolicy extends HttpServlet {
    protected PolicyDao policyDao;

    @Override
    public void init() throws ServletException {
        policyDao = PolicyDao.getInstance();
    }

    /**
     * Get method looks in the StateCountyProfile.jsp for "fips" and returns the
     * fips value. Then it calls on the DAOs to find the corresponding policies for that fips
     * and renders that information to the Policy.jsp file
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Map for storing messages
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);

        // Defines paramaters in URL bar ie /policy?fips=6031 from the StateCountyProfile jsp
        Integer fips = Integer.valueOf(req.getParameter("fips"));
        List<Policy> policyList = new ArrayList<>();

        try {
            if (fips != null) {
                CountyProfileDao countyProfileDao = CountyProfileDao.getInstance();
                CountyProfile county = countyProfileDao.getCountyByCountyFIPS(fips);

                policyList = policyDao.getPolicyByCountyFips(fips);
                messages.put("title", "Policies for " + county.getCountyName());
            } else {
                messages.put("title", "Invalid fips code");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        req.setAttribute("policyList", policyList);
        req.getRequestDispatcher("/Policy.jsp").forward(req, resp);

    }


}
