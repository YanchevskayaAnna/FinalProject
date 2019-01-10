package dao.interfaces;

import model.Cruise;
import model.CruiseRoute;
import model.Excursion;
import model.dto.CruiseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ICruiseDAO extends IAbstractDAO<Cruise> {

    int calculateCountPassengers(int cruiseID);
    int countNumberEmptySeats(int cruiseID);
    List<Cruise> identifyCurrentCruises(LocalDate date);
    List<Cruise> determinePlannedCruises(LocalDate date);
    List<CruiseDto> defineCruises(int idClient);
    List<CruiseDto> getAllCruisesDto();

}
