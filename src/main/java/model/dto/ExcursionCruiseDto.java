package model.dto;

import java.util.Objects;

public class ExcursionCruiseDto {
    private int id;
    private String name;
    private int price;
    private String cruiseName;
    private String portName;
    private int cruiseID;
    private int portID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcursionCruiseDto that = (ExcursionCruiseDto) o;
        return id == that.id &&
                cruiseID == that.cruiseID &&
                portID == that.portID;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cruiseID, portID);
    }

    public ExcursionCruiseDto() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCruiseName() {
        return cruiseName;
    }

    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public int getCruiseID() {
        return cruiseID;
    }

    public void setCruiseID(int cruiseID) {
        this.cruiseID = cruiseID;
    }

    public int getPortID() {
        return portID;
    }

    public void setPortID(int portID) {
        this.portID = portID;
    }
}
