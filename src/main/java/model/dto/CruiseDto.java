package model.dto;

import anotations.Column;
import model.Ship;

import java.time.LocalDate;

public class CruiseDto { //to do нужен этот класс?
    private String name;
    private String number;
    private Ship ship;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private int price;
    private int countOfDays;
}
