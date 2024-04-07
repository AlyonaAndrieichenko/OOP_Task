package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class StandardClient extends Client{
    private boolean wasOnceInactive;

    public StandardClient(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    public boolean isWasOnceInactive() {
        return wasOnceInactive;
    }

    public void setWasOnceInactive(boolean wasOnceInactive) {
        this.wasOnceInactive = wasOnceInactive;
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
