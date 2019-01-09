package servlets.actions.guest;

import model.User;
import model.UserRole;
import services.impl.CryptWithMD5;
import servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Register extends FrontCommand {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("invalid_data_entered", false);
        if (validateRequest(request)) {
            User user = new User();
            user.setRole(UserRole.CLIENT);
            user.setName(request.getParameter("name"));
            user.setPhone(request.getParameter("phone"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(CryptWithMD5.cryptWithMD5(request.getParameter("password")));

            if (userService.createUser(user)) {
                return new ShowLoginPage().execute(request, response);
            } else {
                request.setAttribute("invalid_data_entered", true);
                return "registration";
            }
        } else {
            request.setAttribute("invalid_data_entered", true);
            return "registration";
        }
    }

    private boolean validateRequest(HttpServletRequest request) {
        ResourceBundle regexps = ResourceBundle.getBundle("regexps");
        boolean allFieldsValid = true;
        List<String> fields = Arrays.asList(
                "email", "password");

        for (String field : fields) {
            String value = request.getParameter(field);
            if (value.matches(regexps.getString(field))) {
                request.setAttribute(field, value);
                continue;
            }
            allFieldsValid = false;
        }

        return allFieldsValid;
    }

}