package model;

import anotations.Column;
import anotations.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Table(name="cruises")
public class Cruise extends _IDEntity{

    @Column(name = "cruise_name")
    private String name;
    @Column(name = "cruise_number")
    private String number;
    @Column(name = "cruise_idShip")
    private int idShip;
    @Column(name = "cruise_dateStart")
    private LocalDate dateStart;
    @Column(name = "cruise_dateFinish")
    private LocalDate dateFinish;
    @Column(name = "cruise_price")
    private int price;

    private List<Client> passengers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getIdShip() {
        return idShip;
    }

    public void setIdShip(int idShip) {
        this.idShip = idShip;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Client> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Client> passengers) {
        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cruise cruise = (Cruise) o;
        return idShip == cruise.idShip &&
                price == cruise.price &&
                Objects.equals(name, cruise.name) &&
                Objects.equals(number, cruise.number) &&
                Objects.equals(dateStart, cruise.dateStart) &&
                Objects.equals(dateFinish, cruise.dateFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, idShip, dateStart, dateFinish, price);
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", idShip=" + idShip +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", price=" + price +
                '}';
    }
}
