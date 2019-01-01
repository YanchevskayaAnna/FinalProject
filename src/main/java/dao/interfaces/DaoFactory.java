package dao.interfaces;

import dao.SQLDao.SQLDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract IClientDAO createClientDao();
    public abstract ICruiseDAO createCruiseDao();
    public abstract IExcursionDAO createExcursionDao();
    public abstract IExcursionTicketDAO createExcursionTicketDao();
    public abstract IPortDAO createPortDao();
    public abstract IShipDAO createShipDao();
    public abstract ITicketDAO createTicketDao();
    public abstract ICruiseRouteDAO createCruiseRouteDao();
    public abstract IBonusDAO createBonusDao();
    public abstract ITicketBonusesDAO createTicketBonusesDao();

    public static DaoFactory getInstance(){
            if( daoFactory == null ){
                synchronized (DaoFactory.class){
                    if(daoFactory==null){
                        DaoFactory temp = new SQLDaoFactory();
                        daoFactory = temp;
                    }
                }
            }
            return daoFactory;
        }
}
