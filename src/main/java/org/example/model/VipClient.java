package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
public class VipClient extends Client {
    private boolean satisfied;

    public VipClient(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
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
