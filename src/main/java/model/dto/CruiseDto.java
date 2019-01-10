package model.dto;

import anotations.Column;
import model.Ship;

import java.time.LocalDate;

public class CruiseDto {
    private int id;
    private String name;
    private String number;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private int price;
    private int countOfDays;
    private int shipID;
    private String shipName;
    private int shipCapacity;
    private int countFreePlaces;

    public CruiseDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getCountOfDays() {
        return countOfDays;
    }

    public void setCountOfDays(int countOfDays) {
        this.countOfDays = countOfDays;
    }

    public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getShipCapacity() {
        return shipCapacity;
    }

    public void setShipCapacity(int shipCapacity) {
        this.shipCapacity = shipCapacity;
    }

    public int getCountFreePlaces() {
        return countFreePlaces;
    }

    public void setCountFreePlaces(int countFreePlaces) {
        this.countFreePlaces = countFreePlaces;
    }
}
