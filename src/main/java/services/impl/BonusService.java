package services.impl;

import dao.interfaces.IBonusDAO;
import model.Bonus;
import services.interfaces.IBonusService;

import java.util.List;

public class BonusService implements IBonusService {
    private IBonusDAO bonusDAO;

    public BonusService(IBonusDAO bonusDAO) {
        this.bonusDAO = bonusDAO;
    }

    @Override
    public List<Bonus> getAllBonuses() {
        return bonusDAO.getAll();
    }

    @Override
    public List<Bonus> defineBonuses(int idClient, int idCruise) {
        return bonusDAO.defineBonuses(idClient, idCruise);
    }

    @Override
    public Bonus getBonusId(Integer id) {
        return bonusDAO.getById(id);
    }

    @Override
    public boolean updateBonus(Bonus bonus) {
        return bonusDAO.update(bonus);
    }

    @Override
    public boolean createBonus(Bonus bonus) {
        return bonusDAO.create(bonus);
    }

    @Override
    public boolean deleteBonus(Bonus bonus) {
        return bonusDAO.delete(bonus);
    }

    @Override
    public boolean deleteBonusById(Integer id) {
        return bonusDAO.deleteById(id);
    }
}
