package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class VipClient extends Client{
    private boolean satisfied;

    public VipClient(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    public boolean isSatisfied() {
        return satisfied;
    }

    public void setSatisfied(boolean satisfied) {
        this.satisfied = satisfied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VipClient vipClient = (VipClient) o;
        return satisfied == vipClient.satisfied;
    }

    @Override
    public int hashCode() {
        return Objects.hash(satisfied);
    }

    @Override
    public String toString() {
        return "VipClient{" +
                "satisfied=" + satisfied +
                '}';
    }

    @Override
    public int calculateClientPresent() {
        if (!satisfied) return 200;
        return 0;
    }

}
