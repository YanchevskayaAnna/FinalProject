package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="tickets")
public class Ticket extends _IDEntity{

    @Column(name = "ticket_idclient")
    private int idClient;

    @Column(name = "ticket_idcruise")
    private int idCruise;

    @Column(name = "ticket_price")
    private int price;

    public Ticket() {
    }

    public Ticket(int idClient, int idCruise, int price) {
        this.idClient = idClient;
        this.idCruise = idCruise;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                idClient == ticket.idClient &&
                idCruise == ticket.idCruise;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idClient, idCruise);
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "number=" + id +
                ", price=" + price +
                ", idClient=" + idClient +
                ", idCruise=" + idCruise +
                '}';
    }


}
