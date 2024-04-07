package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PaidCard getPaidCard() {
        return paidCard;
    }

    public void setPaidCard(PaidCard paidCard) {
        this.paidCard = paidCard;
    }

    public void setNeedMedicalInsurance(boolean needMedicalInsurance) {
        this.needMedicalInsurance = needMedicalInsurance;
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
