package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="ticketbonuses")
public class TicketBonuses extends _IDEntity{
    @Column(name = "ticketbonuses_idTicket")
    private int idTicket;

    @Column(name = "ticketbonuses_idBonus")
    private int idBonus;

    @Column(name = "ticketbonuses_price")
    private int price;

    public TicketBonuses() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdBonus() {
        return idBonus;
    }

    public void setIdBonus(int idBonus) {
        this.idBonus = idBonus;
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
        TicketBonuses that = (TicketBonuses) o;
        return idTicket == that.idTicket &&
                idBonus == that.idBonus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idTicket, idBonus);
    }

    @Override
    public String toString() {
        return "TicketBonuses{" +
                "idTicket=" + idTicket +
                ", idBonus=" + idBonus +
                '}';
    }

}
