package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class Address {
    private City city;
    private int houseNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && city == address.city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, houseNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
