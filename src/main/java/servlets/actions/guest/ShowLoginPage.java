package servlets.actions.guest;

import servlets.FrontCommand;
import servlets.actions.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowLoginPage extends FrontCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException{
        return "login&registration/login";
    }

}
