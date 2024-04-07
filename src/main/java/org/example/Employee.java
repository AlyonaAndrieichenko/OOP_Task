package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Objects;

public class Employee implements IHumanResource{
    private final String name;
    private final String surname;
    private Address homeAddress;
    private LocalDate birthDate;

    public Employee(String name, String surname, LocalDate birthDate) {
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, homeAddress, birthDate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", homeAddress=" + homeAddress +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean needMedicalInsurance() {
        Period period = Period.between(birthDate, LocalDate.now());
        int age = period.getYears();
        if (age >= 35) return true;
        return false;
    }

}
