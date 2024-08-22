package org.example;

import org.example.model.*;
import org.example.service.DebtService;

import java.time.LocalDate;
import java.util.HashMap;

import static org.example.model.City.BERLIN;

public class Main {
    public static void main(String[] args) {

        //Create a VIP client
        VipClient vipClient = new VipClient("John", "Smith", LocalDate.of(1959, 12, 03));
        vipClient.setAddress(new Address(BERLIN, 12));
        vipClient.setActive(true);

        //Create 2 standard clients
        StandardClient standardClientOne = new StandardClient("Mary", "Watson", LocalDate.of(1963, 8, 23));
        standardClientOne.setActive(true);
        standardClientOne.setAddress(new Address(BERLIN, 58));
        Client standardClientTwo = new StandardClient("Nik", "Niklson", LocalDate.of(1968, 8, 19));

        //Calculate the gift amount for a standard client
        System.out.println(standardClientOne.calculateClientPresent());

        //Calculate the gift amount for a VIP client
        System.out.println(vipClient.calculateClientPresent());

        //VIP client paid January 01, 2024 1000
        PaidCard paidCardVip = new PaidCard();
        vipClient.setPaidCard(paidCardVip);
        HashMap<LocalDate, Integer> paymentMap = new HashMap<>();
        paymentMap.put(LocalDate.of(2024, 1, 1), 1000);
        paidCardVip.setPaidMoney(paymentMap);

        //VIP client paid on March 15, 2024 1000
        paymentMap.put(LocalDate.of(2024, 3, 15), 1000);
        paidCardVip.setPaidMoney(paymentMap);

        //Standard client paid on December 15, 2022 500
        PaidCard paidCardStandard = new PaidCard();
        standardClientOne.setPaidCard(paidCardStandard);
        HashMap<LocalDate, Integer> paymentMapStandard = new HashMap<>();
        paymentMapStandard.put(LocalDate.of(2022, 12, 15), 500);
        paidCardStandard.setPaidMoney(paymentMapStandard);

        //Standard client paid on December 19, 2022 500
        paymentMapStandard.put(LocalDate.of(2022, 12, 19), 500);
        paidCardStandard.setPaidMoney(paymentMapStandard);

        //Is the VIP client in debt?
        DebtService debtService = new DebtService();
        System.out.println(debtService.isDebtorByCard(paidCardVip));

        //Is the standard client in debt?
        System.out.println(debtService.isDebtorByCard(paidCardStandard));

        //Is it possible to write off debts for a VIP client?
        System.out.println(debtService.cancelDebts(vipClient));

        //Is it possible to write off debts for a standard client?
        System.out.println(debtService.cancelDebts(standardClientOne));

        //Create an employee
        Employee employee = new Employee("Max", "Maximchuk", LocalDate.of(1997, 4, 11));

        //Does an employee need insurance?
        System.out.println(employee.needMedicalInsurance());

        //Does a VIP client need insurance?
        System.out.println(vipClient.needMedicalInsurance());

        //Does a standard client need insurance?
        System.out.println(standardClientOne.needMedicalInsurance());

    }
}