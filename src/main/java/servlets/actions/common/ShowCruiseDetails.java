package servlets.actions.common;

import servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowCruiseDetails extends FrontCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("cruiseName", request.getParameter("cruiseName"));
        request.setAttribute("cruiseID", request.getParameter("cruiseID"));
        request.setAttribute("ship", request.getParameter("ship"));
        request.setAttribute("shipCapacity", request.getParameter("shipCapacity"));
        request.setAttribute("countFreePlaces", request.getParameter("countFreePlaces"));
        request.setAttribute("ports", cruiseRouteService.getCruiseRoute(Integer.parseInt(request.getParameter("cruiseID"))));
        return "common/cruise";
    }
}
