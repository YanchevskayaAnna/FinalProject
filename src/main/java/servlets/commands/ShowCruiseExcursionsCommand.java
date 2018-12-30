package servlets.commands;

import servlets.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

public class ShowCruiseExcursionsCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        request.setAttribute("cruiseName", request.getParameter("cruiseName"));
        request.setAttribute("cruiseID", request.getParameter("cruiseID"));
        request.setAttribute("portID", request.getParameter("portID"));
        request.setAttribute("excursions", excursionService.getPortExcursions(Integer.parseInt(request.getParameter("portID"))));
        forward("excursion");
    }
}
