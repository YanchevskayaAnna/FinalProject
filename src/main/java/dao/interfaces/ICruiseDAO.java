package dao.interfaces;

import model.Cruise;
import model.Excursion;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ICruiseDAO extends IAbstractDAO<Cruise> {

    int calculateCountPassengers(int cruiseID);
    int countNumberEmptySeats(int cruiseID);
    Map<Excursion, Integer> findExcursions(int cruiseID);
    List<Excursion> findCruiseExcursions(int cruiseID);
    List<Cruise> identifyCurrentCruises(LocalDate date);
    Map<Cruise, LocalDate> determinePlannedCruises(LocalDate date);

}
