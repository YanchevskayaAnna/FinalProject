package servlets.listeners;

import model.UserRole;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private static final String DEFAULT_LANG = "en";

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute("userRole", UserRole.GUEST);
        httpSessionEvent.getSession().setAttribute("lang", DEFAULT_LANG);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
