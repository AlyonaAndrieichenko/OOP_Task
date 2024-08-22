package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
public class StandardClient extends Client {
    private boolean wasOnceInactive;

    public StandardClient(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StandardClient that = (StandardClient) o;
        return wasOnceInactive == that.wasOnceInactive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wasOnceInactive);
    }

    @Override
    public String toString() {
        return "StandardClient{" +
                "wasOnceInactive=" + wasOnceInactive +
                '}';
    }

    @Override
    public int calculateClientPresent() {
        if (isWasOnceInactive()) return 50;
        return 100;
    }
}
