package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="ships")
public class Ship extends _IDEntity{
    @Column(name = "ship_name")
    private String name;
    @Column(name = "ship_number")
    private String number;
    @Column(name = "ship_passengercapacity")
    private int passengerCapacity;

    public Ship() {
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return Objects.equals(number, ship.number);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                '}';
    }
}
