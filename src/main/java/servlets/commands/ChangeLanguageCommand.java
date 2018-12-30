package servlets.commands;

import servlets.FrontCommand;

import javax.servlet.ServletException;
import java.io.IOException;

public class ChangeLanguageCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        request.setAttribute("cruises", cruiseService.getAllCruises());
        request.getSession().setAttribute("lang", request.getParameter("lang"));
        forward("travelcompany");
    }
}