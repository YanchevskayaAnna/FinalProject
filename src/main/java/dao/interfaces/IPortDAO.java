package dao.interfaces;

import model.Excursion;
import model.Port;

import java.util.List;

public interface IPortDAO extends IAbstractDAO<Port> {

    List<Excursion> FindExcursions(int portID);

}
