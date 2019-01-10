package servlets.actions.common;

import servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowCruiseExcursions extends FrontCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("cruiseName", request.getParameter("cruiseName"));
        request.setAttribute("cruiseID", request.getParameter("cruiseID"));
        request.setAttribute("portID", request.getParameter("portID"));
        request.setAttribute("portName", request.getParameter("portName"));
        request.setAttribute("excursions", excursionService.getPortExcursions(Integer.parseInt(request.getParameter("portID"))));
        return "common/excursion";
    }
}
