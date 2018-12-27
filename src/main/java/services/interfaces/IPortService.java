package services.interfaces;

import model.Excursion;
import model.Port;

import java.util.List;

public interface IPortService {
    List<Excursion> findExcursions(int portID);
    Port getPortId(Integer id);
    boolean updatePort(Port port);
    boolean createPort(Port port);
    boolean deletePort(Port port);
    boolean deletePortById(Integer id);
}
