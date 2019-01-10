package integration;

import dao.interfaces.DaoFactory;
import model.User;
import model.UserRole;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.impl.UserService;
import services.interfaces.IUserService;


public class TestUser {

    private static IUserService userService;

    @BeforeClass
    public static void beforeClass()  {
        DaoFactory factory = DaoFactory.getInstance();
        userService = new UserService(factory.createUserDao());
    }

    @AfterClass
    public static void afterClass()  {

    }

    @Test
    public void testCreateUser() {
        int countClientsBefore = userService.getAllUsers().size();
        User client = new User("Test", UserRole.CLIENT, "test@test.com", "+380679995566");
        userService.createUser(client);
        int countClientsAfter = userService.getAllUsers().size();
        Assert.assertNotNull(countClientsAfter = countClientsBefore + 1);
    }

}
