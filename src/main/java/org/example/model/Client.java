package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Getter
@Setter
public abstract class Client implements IHumanResource {
    private final String name;
    private final String surname;
    private final LocalDate birthDate;
    private boolean active;
    private Address address;
    private PaidCard paidCard;
    private boolean needMedicalInsurance;

    public Client(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return active == client.active && needMedicalInsurance == client.needMedicalInsurance && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(birthDate, client.birthDate) && Objects.equals(address, client.address) && Objects.equals(paidCard, client.paidCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, active, address, paidCard, needMedicalInsurance);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                ", address=" + address +
                ", paidCard=" + paidCard +
                ", needMedicalInsurance=" + needMedicalInsurance +
                '}';
    }

    public abstract int calculateClientPresent();

    @Override
    public boolean needMedicalInsurance() {
        Period period = Period.between(birthDate, LocalDate.now());
        int age = period.getYears();
        if (active && age >= 55 && address.getCity() == City.BERLIN) return true;
        return false;
    }
}
