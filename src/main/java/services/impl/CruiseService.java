package services.impl;

import dao.interfaces.ICruiseDAO;
import model.Cruise;
import model.dto.CruiseDto;
import services.interfaces.ICruiseService;

import java.time.LocalDate;
import java.util.List;

public class CruiseService implements ICruiseService {
    private ICruiseDAO cruiseDAO;

    public CruiseService(ICruiseDAO cruiseDAO) {
        this.cruiseDAO = cruiseDAO;
    }

    @Override
    public List<Cruise> getAllCruises() {
        return cruiseDAO.getAll();
    }

    @Override
    public int calculateCountPassengers(int cruiseID) {
        return cruiseDAO.calculateCountPassengers(cruiseID);
    }

    @Override
    public int countNumberEmptySeats(int cruiseID) {
        return cruiseDAO.countNumberEmptySeats(cruiseID);
    }

    @Override
    public List<CruiseDto> defineCruises(int idClient) {
        return cruiseDAO.defineCruises(idClient);
    }

    @Override
    public List<Cruise> identifyCurrentCruises(LocalDate date) {
        return cruiseDAO.identifyCurrentCruises(date);
    }

    @Override
    public List<Cruise> determinePlannedCruises(LocalDate date) {
        return cruiseDAO.determinePlannedCruises(date);
    }

    @Override
    public Cruise getCruiseId(Integer id) {
        return cruiseDAO.getById(id);
    }

    @Override
    public boolean updateCruise(Cruise cruise) {
        return cruiseDAO.update(cruise);
    }

    @Override
    public boolean createCruise(Cruise cruise) {
        return cruiseDAO.create(cruise);
    }

    @Override
    public boolean deleteCruise(Cruise cruise) {
        return cruiseDAO.delete(cruise);
    }

    @Override
    public boolean deleteCruiseById(Integer id) {
        return cruiseDAO.deleteById(id);
    }

    @Override
    public List<CruiseDto> getAllCruisesDto() {
        return cruiseDAO.getAllCruisesDto();
    }
}
