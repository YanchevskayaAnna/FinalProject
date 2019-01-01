package servlets;

import dao.interfaces.ICruiseRouteDAO;
import services.interfaces.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {
    private ServletContext context;
    protected HttpServletRequest request;
    private HttpServletResponse response;
    protected IClientService clientService;
    protected ICruiseService cruiseService;
    protected ICruiseRouteService cruiseRouteService;
    protected IExcursionService excursionService;
    protected IExcursionTicketService excursionTicketService;
    protected IPortService portService;
    protected IShipService shipService;
    protected ITicketClassService ticketClassService;
    protected ITicketService ticketService;
    protected IBonusService bonusService;

    public void init(
            ServletContext servletContext,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse,
            IClientService clientService,
            ICruiseService cruiseService,
            ICruiseRouteService cruiseRouteService,
            IExcursionService excursionService,
            IExcursionTicketService excursionTicketService,
            IPortService portService,
            IShipService shipService,
            ITicketClassService ticketClassService,
            ITicketService ticketService,
            IBonusService bonusService) {

        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
        this.clientService = clientService;
        this.cruiseService = cruiseService;
        this.cruiseRouteService = cruiseRouteService;
        this.excursionService = excursionService;
        this.excursionTicketService = excursionTicketService;
        this.portService = portService;
        this.shipService = shipService;
        this.ticketClassService = ticketClassService;
        this.ticketService = ticketService;
        this.bonusService = bonusService;

      }

    public abstract void process() throws ServletException, IOException;

    protected void forward(String target) throws ServletException, IOException {
        target = String.format("/WEB-INF/pages/%s.jsp", target);
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}