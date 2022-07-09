package safe.servlet;

import safe.dal.*;
import safe.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ustravel")
public class ServUSTravel extends HttpServlet {

    protected USTravelDao usTravelDao;

    @Override
    public void init() throws ServletException {
        usTravelDao = USTravelDao.getInstance();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);
        USTravel usTravelState = null;
        String statename  = req.getParameter("statename");
        USTravelDao usTravelDao = USTravelDao.getInstance();
        try {
            if (statename == null || statename.trim().isEmpty()) {
                messages.put("title", "Invalid statename");
            } else {
                usTravelState = usTravelDao.getTravelStatisticsByStateName(statename);
                messages.put("title", "Travel statistics for state " + statename);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        req.setAttribute("usTravelState", usTravelState);
        req.getRequestDispatcher("/USTravel.jsp").forward(req, resp);
    }
}
