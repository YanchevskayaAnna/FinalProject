package servlets.actions.common;

import servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowMainPage extends FrontCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("cruises", cruiseService.getAllCruises());
        request.setAttribute("UserLogIn", request.getSession().getAttribute("UserLogIn"));
        request.setAttribute("userName", request.getSession().getAttribute("userName"));
        return "travelcompany";
    }
}
