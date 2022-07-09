package safe.servlet;

import safe.dal.*;
import safe.model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/stateprofile")
public class ServeStateProfiles extends HttpServlet {

  protected StateProfileDao stateProfileDao;
  protected USTravelDao usTravelDao;

  @Override
  public void init() throws ServletException {
    stateProfileDao = StateProfileDao.getInstance();
    usTravelDao = USTravelDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    List<StateProfile> stateProfiles = new ArrayList<>();
    USTravel usTravel = null;

    String stateName = req.getParameter("name");
    if (stateName == null || stateName.trim().isEmpty()) {
      messages.put("success", "Please enter a valid state name.");
    } else {
      // Retrieve stateName data, and store as a message.
      try {
        StateProfile stateProfile = stateProfileDao.getStateProfileByName(stateName);
        stateProfiles.add(stateProfile);
        
        usTravel = usTravelDao.getTravelStatisticsByStateName(stateName);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for " + stateName.toUpperCase());
      // Save the previous search term, so it can be used as the default
      // in the input box when rendering FindUsers.jsp.
      messages.put("previous stateName", stateName);
    }
    req.setAttribute("stateProfiles", stateProfiles);
    req.setAttribute("usTravel", usTravel);
    req.getRequestDispatcher("/StateProfile.jsp").forward(req, resp);
  }


}
