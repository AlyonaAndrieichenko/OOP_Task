package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.config.ClientType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

@Setter
@Getter
public class PaidCard {
    private HashMap<LocalDate, Integer> paidMoney;
    private ClientType clientType;

    @Override
    public int hashCode() {
        return Objects.hash(paidMoney, clientType);
    }

    @Override
    public String toString() {
        return "PaidCard{" +
                "paidMoney=" + paidMoney +
                ", clientType=" + clientType +
                '}';
    }

    public void payMoney(ClientType clientType){
        if (clientType == ClientType.VIP) paidMoney.put(LocalDate.now(), 1000);
        if (clientType == ClientType.STANDARD) paidMoney.put(LocalDate.now(), 500);
    }

}
