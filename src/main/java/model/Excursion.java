package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="excursions")
public class Excursion extends _IDEntity{

    @Column(name = "excursion_name")
    private String name;
    @Column(name = "excursion_price")
    private int price;
    @Column(name = "excursion_id_port")
    private int idPort;

    public Excursion(String name, int price, int idPort) {
        this.name = name;
        this.price = price;
        this.idPort = idPort;
    }

    public Excursion() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdPort() {
        return idPort;
    }

    public void setIdPort(int idPort) {
        this.idPort = idPort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Excursion excursion = (Excursion) o;
        return price == excursion.price &&
                idPort == excursion.idPort &&
                Objects.equals(name, excursion.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, price, idPort);
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", idPort=" + idPort +
                '}';
    }
}
