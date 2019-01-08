package servlets;

import dao.interfaces.ICruiseRouteDAO;
import services.interfaces.*;
import servlets.actions.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand implements Action{
    private ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ICruiseService cruiseService;
    protected ICruiseRouteService cruiseRouteService;
    protected IExcursionService excursionService;
    protected IExcursionTicketService excursionTicketService;
    protected IPortService portService;
    protected IShipService shipService;
    protected ITicketService ticketService;
    protected IBonusService bonusService;
    protected ITicketBonusesService ticketBonusesService;
    protected IUserService userService;

    public void init(
            ServletContext servletContext,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse,
            ICruiseService cruiseService,
            ICruiseRouteService cruiseRouteService,
            IExcursionService excursionService,
            IExcursionTicketService excursionTicketService,
            IPortService portService,
            IShipService shipService,
            ITicketService ticketService,
            IBonusService bonusService,
            ITicketBonusesService ticketBonusesService,
            IUserService userService) {

        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
        this.cruiseService = cruiseService;
        this.cruiseRouteService = cruiseRouteService;
        this.excursionService = excursionService;
        this.excursionTicketService = excursionTicketService;
        this.portService = portService;
        this.shipService = shipService;
        this.ticketService = ticketService;
        this.bonusService = bonusService;
        this.ticketBonusesService = ticketBonusesService;
        this.userService = userService;

      }

    protected void forward(String target) throws ServletException, IOException {
        target = String.format("/WEB-INF/pages/%s.jsp", target);
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}