package services.interfaces;

import model.Cruise;
import model.Excursion;
import model.dto.CruiseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ICruiseService {
    List<Cruise> getAllCruises();
    int calculateCountPassengers(int cruiseID);
    int countNumberEmptySeats(int cruiseID);
    List<CruiseDto> defineCruises(int idClient);
    List<Cruise> identifyCurrentCruises(LocalDate date);
    List<Cruise> determinePlannedCruises(LocalDate date);
    Cruise getCruiseId(Integer id);
    boolean updateCruise(Cruise cruise);
    boolean createCruise(Cruise cruise);
    boolean deleteCruise(Cruise cruise);
    boolean deleteCruiseById(Integer id);
    List<CruiseDto> getAllCruisesDto();
}
