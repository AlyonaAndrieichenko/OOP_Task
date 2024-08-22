package org.example.service;

import org.example.model.Client;
import org.example.model.PaidCard;
import org.example.config.ClientType;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.TreeMap;



public class DebtService {
    private static final int VIP_DURATION = 90;
    private static final int STANDARD_DURATION = 30;
    private static final int CARD_VALID_DURATION_COEF = 2;

    public boolean isDebtorByCard(PaidCard paidCard) {
        LocalDate paidDate = null;
        for (LocalDate key : paidCard.getPaidMoney().keySet()) {
            paidDate = key;
        }
        Period period = Period.between(paidDate, LocalDate.now());
        int days = period.getDays();
        if (paidCard.getClientType() == ClientType.VIP && days >= VIP_DURATION) return true;
        else if (paidCard.getClientType() == ClientType.STANDARD && days >= STANDARD_DURATION) return true;
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
        if (client.isActive() && lastDate.getValue() > preLastDate.getValue() * CARD_VALID_DURATION_COEF) return true;
        return false;
    }
}
