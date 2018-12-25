package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="ports")
public class Port extends _IDEntity{
    @Column(name = "port_name")
    private String name;

    public Port() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Port port = (Port) o;
        return Objects.equals(name, port.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Port{" +
                "name='" + name + '\'' +
                '}';
    }
}
