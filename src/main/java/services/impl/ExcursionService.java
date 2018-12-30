package services.impl;

import dao.interfaces.IExcursionDAO;
import model.Excursion;
import services.interfaces.IExcursionService;

import java.util.List;

public class ExcursionService implements IExcursionService {
    private IExcursionDAO excursionDAO;

    public ExcursionService(IExcursionDAO excursionDAO) {
        this.excursionDAO = excursionDAO;
    }

    @Override
    public List<Excursion> getAllExcursions() {
        return excursionDAO.getAll();
    }

    @Override
    public Excursion getExcursionId(Integer id) {
        return excursionDAO.getById(id);
    }

    @Override
    public boolean updateExcursion(Excursion excursion) {
        return excursionDAO.update(excursion);
    }

    @Override
    public boolean createExcursion(Excursion excursion) {
        return excursionDAO.create(excursion);
    }

    @Override
    public boolean deleteExcursion(Excursion excursion) {
        return excursionDAO.delete(excursion);
    }

    @Override
    public boolean deleteExcursionById(Integer id) {
        return excursionDAO.deleteById(id);
    }

    @Override
    public List<Excursion> getPortExcursions(int idPort) {
        return excursionDAO.getPortExcursions(idPort);
    }
}
