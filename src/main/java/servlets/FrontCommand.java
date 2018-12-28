package servlets;

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
    private IClientService clientService;
    protected ICruiseService cruiseService;
    private IExcursionService excursionService;
    private IExcursionTicketService excursionTicketService;
    private IPortService portService;
    private IShipService shipService;
    private ITicketClassService ticketClassService;
    private ITicketService ticketService;

    public void init(
            ServletContext servletContext,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse,
            IClientService clientService,
            ICruiseService cruiseService,
            IExcursionService excursionService,
            IExcursionTicketService excursionTicketService,
            IPortService portService,
            IShipService shipService,
            ITicketClassService ticketClassService,
            ITicketService ticketService) {

        this.context = servletContext;
        this.request = servletRequest;
        this.response = servletResponse;
        this.clientService = clientService;
        this.cruiseService = cruiseService;
        this.excursionService = excursionService;
        this.excursionTicketService = excursionTicketService;
        this.portService = portService;
        this.shipService = shipService;
        this.ticketClassService = ticketClassService;
        this.ticketService = ticketService;

      }

    public abstract void process() throws ServletException, IOException;

    protected void forward(String target) throws ServletException, IOException {
        target = String.format("/WEB-INF/pages/%s.jsp", target);
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}