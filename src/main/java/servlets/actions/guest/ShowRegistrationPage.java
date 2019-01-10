package servlets.actions.guest;

import servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowRegistrationPage extends FrontCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        return "login&registration/registration";
    }
}
