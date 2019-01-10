package servlets.actions.adminShip;

import servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAdminShipInfo extends FrontCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int userID =  Integer.parseInt(request.getSession().getAttribute("userID").toString());
        request.setAttribute("clientID", userID);
        request.setAttribute("cruises", cruiseService.defineCruises(userID));
        request.setAttribute("excursions", excursionService.defineExcursions(userID));
        request.setAttribute("UserLogIn", request.getSession().getAttribute("UserLogIn"));
        request.setAttribute("userName", request.getSession().getAttribute("userName"));
        return "adminship/adminshipinfo";
    }
}
