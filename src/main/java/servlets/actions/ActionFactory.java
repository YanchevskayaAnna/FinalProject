package servlets.actions;

import servlets.actions.adminShip.ShowAdminShipInfo;
import servlets.actions.client.ShowClientInfo;
import servlets.actions.common.*;
import servlets.actions.guest.Login;
import servlets.actions.guest.Register;
import servlets.actions.guest.ShowLoginPage;
import servlets.actions.guest.ShowRegistrationPage;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    private static final ActionFactory instance = new ActionFactory();

    public static ActionFactory getInstance() {
        return instance;
    }

    private ActionFactory() {}

    private Map<String, Action> actions = new HashMap<>();
    private Action defaultAction = new ShowMainPage();

    {
        actions.put("ShowCruiseDetails", new ShowCruiseDetails());
        actions.put("/ShowCruiseDetails", new ShowCruiseDetails());
        actions.put("ShowCruiseExcursions", new ShowCruiseExcursions());
        actions.put("/ShowCruiseExcursions", new ShowCruiseExcursions());

        actions.put("/ShowUserInfo", new ShowUserInfo());
        actions.put("/ShowClientInfo", new ShowClientInfo());
        actions.put("/ShowAdminShipInfo", new ShowAdminShipInfo());

        actions.put("ShowLoginPage", new ShowLoginPage());
        actions.put("/ShowLoginPage", new ShowLoginPage());
        actions.put("ShowRegistrationPage", new ShowRegistrationPage());
        actions.put("/ShowRegistrationPage", new ShowRegistrationPage());

        actions.put("Login", new Login());
        actions.put("Register", new Register());
        actions.put("LogOut", new LogOut());

        actions.put("ChangeLanguage", new ChangeLanguage());
    }

    public Action getShowPageAction(HttpServletRequest request) {
        return actions.getOrDefault(request.getServletPath(), defaultAction);
    }

    public Action getAction(HttpServletRequest request) {
        String command = request.getParameter("command");
        if (command == null) {
            return getShowPageAction(request);
        }
        return actions.getOrDefault(command, defaultAction);
    }
}

