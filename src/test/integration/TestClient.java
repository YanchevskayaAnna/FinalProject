package integration;

import dao.interfaces.DaoFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestClient {

    private static IClientService clientService;

    @BeforeClass
    public static void beforeClass()  {
        DaoFactory factory = DaoFactory.getInstance();
        clientService = new ClientService(factory.createClientDao());
    }

    @AfterClass
    public static void afterClass()  {

    }

    @Test
    public void testCreateClient() {
        int countClientsBefore = clientService.getAllClients().size();
        Client client = new Client("Test", "test@test.com", "+380679995566");
        clientService.createClient(client);
        int countClientsAfter = clientService.getAllClients().size();
        Assert.assertNotNull(countClientsAfter = countClientsBefore + 1);
    }

}
