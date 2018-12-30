package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="clients")
public class Client extends _IDEntity{
    @Column(name = "client_name")
    private String name;
    @Column(name = "client_mail")
    private String mail;
    @Column(name = "client_phone")
    private String phone;

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(mail, client.mail) &&
                Objects.equals(phone, client.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, mail, phone);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
