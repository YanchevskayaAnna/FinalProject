package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="clients")
public class Client extends _IDEntity{
    @Column(name = "client_name")
    private String name;
    @Column(name = "client_inn")
    private String identificationNumber;

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(identificationNumber, client.identificationNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(identificationNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                '}';
    }
}
