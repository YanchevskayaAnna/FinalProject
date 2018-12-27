package services.impl;

import dao.interfaces.IPortDAO;
import model.Excursion;
import model.Port;
import services.interfaces.IPortService;

import java.util.List;

public class PortService implements IPortService {
    private IPortDAO portDao;

    public PortService(IPortDAO portDao) {
        this.portDao = portDao;
    }

    @Override
    public List<Excursion> findExcursions(int portID) {
        return portDao.findExcursions(portID);
    }

    @Override
    public Port getPortId(Integer id) {
        return portDao.getById(id);
    }

    @Override
    public boolean updatePort(Port port) {
        return portDao.update(port);
    }

    @Override
    public boolean createPort(Port port) {
        return portDao.create(port);
    }

    @Override
    public boolean deletePort(Port port) {
        return portDao.delete(port);
    }

    @Override
    public boolean deletePortById(Integer id) {
        return portDao.deleteById(id);
    }
}
