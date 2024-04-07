package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

public class PaidCard {

    private HashMap<LocalDate, Integer> paidMoney;
    private ClientType clientType;

    public HashMap<LocalDate, Integer> getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(HashMap<LocalDate, Integer> paidMoney) {
        this.paidMoney = paidMoney;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

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
