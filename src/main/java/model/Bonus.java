package model;

import anotations.Column;
import anotations.Table;

import java.util.Objects;

@Table(name="bonuses")
public class Bonus extends _IDEntity{
    @Column(name = "bonus_name")
    String name;
    @Column(name = "bonus_price")
    int price;

    public Bonus() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        Bonus bonus = (Bonus) o;
        return price == bonus.price &&
                Objects.equals(name, bonus.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
