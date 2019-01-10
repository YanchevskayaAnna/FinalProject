package servlets.actions.common;

import model.UserRole;
import servlets.FrontCommand;
import servlets.actions.adminShip.ShowAdminShipInfo;
import servlets.actions.client.ShowClientInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowUserInfo extends FrontCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        UserRole userRole = UserRole.valueOf(request.getSession().getAttribute("userRole").toString());

        if (userRole.equals(UserRole.CLIENT)) {
            return "redirect:/ShowClientInfo";
        } else if (userRole.equals(UserRole.ADMIN_SHIP)) {
            return "redirect:/ShowAdminShipInfo";
        } else {
            return new ShowMainPage().execute(request, response);
        }

    }
}
