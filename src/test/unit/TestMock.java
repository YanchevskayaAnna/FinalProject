package unit;

import dao.SQLDao.SQLUserDAO;
import model.User;
import model.UserRole;
import org.junit.BeforeClass;
import org.junit.Test;
import services.impl.UserService;
import services.interfaces.IUserService;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestMock {

    private static IUserService clientService;

    @BeforeClass
    public static void init() {

        User client1 = new User("Test1", UserRole.CLIENT, "test1@test.com", "+380679995561");
        User client2 = new User("Test2", UserRole.CLIENT, "test2@test.com", "+380679995562");
        User client3 = new User("Test2", UserRole.CLIENT,  "test3@test.com", "+380679995563");

        SQLUserDAO clientDao = mock(SQLUserDAO.class);
        when(clientDao.getAll()).thenReturn(
                Arrays.asList(
                        client1, client2, client3));

        //when(clientDao.getById(1)).thenReturn(...)
        //when(clientDao.getById(2)).thenReturn(...)
        //when(clientDao.getAll()).thenThrow(new NullPointerException());

        clientService = new UserService(clientDao);
    }

    @Test
    public void getAllClients() {
        assertNotNull(clientService.getAllUsers());
        assertTrue(clientService.getAllUsers().size() == 3);

    }

}
