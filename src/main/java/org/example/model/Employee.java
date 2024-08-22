package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Getter
public class Employee implements IHumanResource {
    private final String name;
    private final String surname;
    @Setter
    private Address homeAddress;
    @Setter
    private LocalDate birthDate;

    public Employee(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
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
