package servlets.actions.common;

import model.UserRole;
import servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOut extends FrontCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setAttribute("role", UserRole.GUEST);
        request.getSession().setAttribute("user", null); // Login user.
        request.getSession().setAttribute("userID", null); // Login user.
        request.getSession().setAttribute("UserLogIn", false);
        request.getSession().setAttribute("userName", "");
        return new RedirectHome().execute(request, response);
    }

}
