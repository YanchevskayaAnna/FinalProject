package servlets.commands;

import servlets.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

public class ShowCruiseCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        request.setAttribute("ports",
                cruiseRouteService.getCruiseRoute(Integer.parseInt(request.getParameter("cruiseID"))));
        forward("cruise");
    }
}
