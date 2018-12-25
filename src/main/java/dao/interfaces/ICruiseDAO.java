package dao.interfaces;

import model.Cruise;
import model.Excursion;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ICruiseDAO extends IAbstractDAO<Cruise> {

    int CalculateCountPassengers(int cruiseID);
    int CountNumberEmptySeats(int cruiseID);
    Map<Excursion, Integer> FindExcursions(int cruiseID);
    List<Excursion> FindCruiseExcursions(int cruiseID);
    List<Cruise> IdentifyCurrentCruises(LocalDate date);
    Map<Cruise, LocalDate> DeterminePlannedCruises(LocalDate date);

}
