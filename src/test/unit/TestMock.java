package unit;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestMock {

    private static IClientService clientService;

    @BeforeClass
    public static void init() {

        Client client1 = new Client("Test1", "test1@test.com", "+380679995561");
        Client client2 = new Client("Test2", "test2@test.com", "+380679995562");
        Client client3 = new Client("Test2", "test3@test.com", "+380679995563");

        SQLClientDAO clientDao = mock(SQLClientDAO.class);
        when(clientDao.getAll()).thenReturn(
                Arrays.asList(
                        client1, client2, client3));

        //when(clientDao.getById(1)).thenReturn(...)
        //when(clientDao.getById(2)).thenReturn(...)
        //when(clientDao.getAll()).thenThrow(new NullPointerException());

        clientService = new ClientService(clientDao);
    }

    @Test
    public void getAllClients() {
        assertNotNull(clientService.getAllClients());
        assertTrue(clientService.getAllClients().size() == 3);

    }

}
