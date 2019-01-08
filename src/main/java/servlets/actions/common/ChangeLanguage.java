package servlets.actions.common;

import servlets.FrontCommand;
import servlets.actions.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLanguage extends FrontCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setAttribute("lang", request.getParameter("lang"));
        return ActionFactory.getInstance().getShowPageAction(request).execute(request, response);
}
}