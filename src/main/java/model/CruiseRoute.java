package model;

import anotations.Column;
import anotations.Table;

import java.time.LocalDate;
import java.util.Objects;

@Table(name="cruise_routs")
public class CruiseRoute extends _IDEntity{
    @Column(name = "cruiserout_idcruise")
    private int idCruise;
    @Column(name = "cruiserout_idport")
    private int idPort;
    @Column(name = "cruiserout_dateArrival")
    private LocalDate dateArrival;

    public CruiseRoute() {
    }

    public int getIdCruise() {
        return idCruise;
    }

    public void setIdCruise(int idCruise) {
        this.idCruise = idCruise;
    }

    public int getIdPort() {
        return idPort;
    }

    public void setIdPort(int idPort) {
        this.idPort = idPort;
    }

    public LocalDate getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(LocalDate dateArrival) {
        this.dateArrival = dateArrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CruiseRoute that = (CruiseRoute) o;
        return idCruise == that.idCruise &&
                idPort == that.idPort &&
                Objects.equals(dateArrival, that.dateArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCruise, idPort, dateArrival);
    }

    @Override
    public String toString() {
        return "CruiseRoute{" +
                "idCruise=" + idCruise +
                ", idPort=" + idPort +
                ", dateArrival=" + dateArrival +
                '}';
    }
}
