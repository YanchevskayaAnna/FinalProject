package model;

import anotations.Column;
import anotations.Table;

import java.util.List;
import java.util.Objects;

@Table(name="ticketclases")
public class TicketClass extends _IDEntity{
    @Column(name = "ticketclass_level")
    private int levelComfort;
    private List<Bonus> bonuses;

    public TicketClass() {
    }

    public int getLevelComfort() {
        return levelComfort;
    }

    public void setLevelComfort(int levelComfort) {
        this.levelComfort = levelComfort;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketClass that = (TicketClass) o;
        return levelComfort == that.levelComfort &&
                Objects.equals(bonuses, that.bonuses);
    }

    @Override
    public int hashCode() {

        return Objects.hash(levelComfort, bonuses);
    }
}
