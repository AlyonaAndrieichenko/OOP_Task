package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.TreeMap;



public class DebtService {
    public boolean isDebtorByCard(PaidCard paidCard) {
        LocalDate paidDate = null;
        for (LocalDate key : paidCard.getPaidMoney().keySet()) {
            paidDate = key;
        }
        Period period = Period.between(paidDate, LocalDate.now());
        int days = period.getDays();
        if (paidCard.getClientType() == ClientType.VIP && days >= 90) return true;
        else if (paidCard.getClientType() == ClientType.STANDARD && days >= 30) return true;
        return false;
    }

    public boolean cancelDebts(Client client) {
        TreeMap<LocalDate, Integer> map = new TreeMap<>(client.getPaidCard().getPaidMoney());
        Map.Entry<LocalDate, Integer> lastDate = null;
        Map.Entry<LocalDate, Integer> preLastDate = null;
        for (Map.Entry<LocalDate, Integer> entry : map.entrySet()){
            preLastDate = lastDate;
            lastDate = entry;
        }
        if (client.isActive() && lastDate.getValue() > preLastDate.getValue()*2) return true;
        return false;
    }
}
