package dao.SQLDao;

import dao.interfaces.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLDaoFactory extends DaoFactory {

    private static final String PROPERTIES_PATH = "src/main/resources/properties";


    private Connection getConnection(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(PROPERTIES_PATH)));
            return DriverManager.getConnection(
                    properties.getProperty("URL"),
                    properties.getProperty("USER"),
                    properties.getProperty("PASSWORD"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public IClientDAO createClientDao() {
        return new SQLClientDAO(getConnection());
    }

    @Override
    public ICruiseDAO createCruiseDao() {
        return new SQLCruiseDAO(getConnection());
    }

    @Override
    public IExcursionDAO createExcursionDao() {
        return new SQLExcursionDAO(getConnection());
    }

    @Override
    public IExcursionTicketDAO createExcursionTicketDao() {
        return new SQLExcursionTicketDAO(getConnection());
    }

    @Override
    public IPortDAO createPortDao() {
        return new SQLPortDAO(getConnection());
    }

    @Override
    public IShipDAO createShipDao() {
        return new SQLShipDAO(getConnection());
    }

    @Override
    public ITicketClassDAO createTicketClassDao() {
        return new SQLTicketClassDAO(getConnection());
    }

    @Override
    public ITicketDAO createTicketDao() {
        return new SQLTicketDAO(getConnection());
    }
}
