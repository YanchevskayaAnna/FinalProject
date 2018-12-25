package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="tickets")
public class Ticket extends _IDEntity{

    @Column(name = "ticket_number")
    private int number;

    @Column(name = "ticket_comfortlevel")
    private int idTicketComfortLevel;

    @Column(name = "ticket_idclient")
    private int idClient;

    @Column(name = "ticket_idcruise")
    private int idCruise;

    public Ticket() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIdTicketComfortLevel() {
        return idTicketComfortLevel;
    }

    public void setIdTicketComfortLevel(int idTicketComfortLevel) {
        this.idTicketComfortLevel = idTicketComfortLevel;
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
        Ticket ticket = (Ticket) o;
        return number == ticket.number &&
                idTicketComfortLevel == ticket.idTicketComfortLevel &&
                idClient == ticket.idClient &&
                idCruise == ticket.idCruise;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, idTicketComfortLevel, idClient, idCruise);
    }



    @Override
    public String toString() {
        return "Ticket{" +
                "number=" + number +
                ", idTicketComfortLevel=" + idTicketComfortLevel +
                ", idClient=" + idClient +
                ", idCruise=" + idCruise +
                '}';
    }
}
