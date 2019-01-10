package model.dto;

import model.Cruise;
import model.Port;

import java.util.Objects;

public class ExcursionCruiseDto {
    private int id;
    private String name;
    private int price;
    private Cruise cruise; // to do это надо?
    private Port port; // to do это надо?
    private String cruiseName;
    private String portName;
    private int cruiseID;
    private int portID;

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

    public ExcursionCruiseDto(int id, String name, int price, Cruise cruise, Port port) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cruise = cruise;
        this.port = port;
    }

    public ExcursionCruiseDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExcursionCruiseDto that = (ExcursionCruiseDto) o;
        return id == that.id &&
                Objects.equals(cruise, that.cruise) &&
                Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cruise, port);
    }

    @Override
    public String toString() {
        return "ExcursionCruiseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cruise=" + cruise +
                ", port=" + port +
                '}';
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

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }
}
