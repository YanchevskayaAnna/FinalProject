package servlets;

import dao.interfaces.DaoFactory;
import services.impl.*;
import services.interfaces.*;
import servlets.commands.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//https://www.baeldung.com/java-front-controller-pattern

@WebServlet(urlPatterns = {"/"})
public class FrontControllerServlet extends HttpServlet {

    private IClientService clientService;
    private ICruiseService cruiseService;
    private IExcursionService excursionService;
    private IExcursionTicketService excursionTicketService;
    private IPortService portService;
    private IShipService shipService;
    private ITicketClassService ticketClassService;
    private ITicketService ticketService;

    @Override
    public void init() throws ServletException {
        DaoFactory factory = DaoFactory.getInstance();
        clientService = new ClientService(factory.createClientDao());
        cruiseService = new CruiseService(factory.createCruiseDao());
        excursionService = new ExcursionService(factory.createExcursionDao());
        excursionTicketService = new ExcursionTicketService(factory.createExcursionTicketDao());
        portService = new PortService(factory.createPortDao());
        shipService = new ShipService(factory.createShipDao());
        ticketClassService = new TicketClassService(factory.createTicketClassDao());
        ticketService = new TicketService(factory.createTicketDao());
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response, clientService, cruiseService, excursionService, excursionTicketService, portService, shipService, ticketClassService, ticketService);
        command.process();
    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            Class type = Class.forName(String.format(
                    "servlets.commands.%sCommand",
                    request.getParameter("command") == null ? "ShowTrains" :request.getParameter("command")));
            return (FrontCommand) type
                    .asSubclass(FrontCommand.class)
                    .newInstance();
        } catch (Exception e) {
            return new UnknownCommand();
        }
    }
}