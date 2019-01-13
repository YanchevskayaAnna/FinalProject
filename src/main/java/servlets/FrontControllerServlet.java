package servlets;

import dao.interfaces.DaoFactory;
import services.impl.*;
import services.interfaces.*;
import servlets.actions.Action;
import servlets.actions.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//https://www.baeldung.com/java-front-controller-pattern

@WebServlet(urlPatterns = {"/"})
public class FrontControllerServlet extends HttpServlet {

    private ActionFactory actionFactory = ActionFactory.getInstance();
    private static final String REDIRECT = "redirect:";
    private static final String FORMAT = "/WEB-INF/pages/%s.jsp";

    private ICruiseService cruiseService;
    private ICruiseRouteService cruiseRouteService;
    private IExcursionService excursionService;
    private IExcursionTicketService excursionTicketService;
    private IPortService portService;
    private IShipService shipService;
    private ITicketService ticketService;
    private IBonusService bonusService;
    private ITicketBonusesService ticketBonusesService;
    private IUserService userService;

    @Override
    public void init() throws ServletException {
        DaoFactory factory = DaoFactory.getInstance();
        cruiseService = new CruiseService(factory.createCruiseDao());
        cruiseRouteService = new CruiseRouteService(factory.createCruiseRouteDao());
        excursionService = new ExcursionService(factory.createExcursionDao());
        excursionTicketService = new ExcursionTicketService(factory.createExcursionTicketDao());
        portService = new PortService(factory.createPortDao());
        shipService = new ShipService(factory.createShipDao());
        ticketService = new TicketService(factory.createTicketDao());
        bonusService = new BonusService(factory.createBonusDao());
        ticketBonusesService = new TicketBonusesService(factory.createTicketBonusesDao());
        userService = new UserService(factory.createUserDao());
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException{
        FrontCommand action = (FrontCommand) actionFactory.getAction(request);
        action.init(getServletContext(), request, response, cruiseService, cruiseRouteService, excursionService, excursionTicketService, portService, shipService, ticketService, bonusService, ticketBonusesService, userService);
        String view = action.execute(request, response);

        if (view.startsWith(REDIRECT)) {
            response.sendRedirect(request.getContextPath() + view.substring(REDIRECT.length()));
        } else if (!view.equals("")){
            request.getRequestDispatcher(String.format(FORMAT, view)).forward(request, response);
        }
    }

}