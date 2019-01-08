package servlets.actions.guest;

import model.User;
import services.impl.CryptWithMD5;
import servlets.FrontCommand;
import servlets.actions.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends FrontCommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userMail = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = userService.getUser(userMail, CryptWithMD5.cryptWithMD5(password));

        if (user != null) {
            request.getSession().setAttribute("user", user); // Login user.
            request.getSession().setAttribute("UserLogIn", true);
            request.getSession().setAttribute("userName", user.getName());
            return "redirect:travelcompany"; // Redirect to home page.
        }
        else {
            request.getSession().setAttribute("user", null); // Login user.
            request.getSession().setAttribute("UserLogIn", false);
            request.getSession().setAttribute("userName", "");
            request.setAttribute("invalid_data_entered", true);
            return "login"; // Go back to redisplay login form with error.
        }
    }

}