package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="excursions_tickets")
public class ExcursionTicket extends _IDEntity{

    @Column(name = "excursionticket_idExcursion")
    private int idExcursion;
    @Column(name = "excursionticket_idclient")
    private int idClient;
    @Column(name = "excursionticket_idcruise")
    private int idCruise;

    public int getIdExcursion() {
        return idExcursion;
    }

    public void setIdExcursion(int idExcursion) {
        this.idExcursion = idExcursion;
    }

    public ExcursionTicket(int idExcursion, int idClient, int idCruise) {
        this.idExcursion = idExcursion;
        this.idClient = idClient;
        this.idCruise = idCruise;
    }

    public ExcursionTicket() {
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }


    public int getIdCruise() {
        return idCruise;
    }

    public void setIdCruise(int idCruise) {
        this.idCruise = idCruise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcursionTicket that = (ExcursionTicket) o;
        return idExcursion == that.idExcursion &&
                idClient == that.idClient &&
                idCruise == that.idCruise;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idExcursion, idClient, idCruise);
    }
}
