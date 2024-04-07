package org.example;

import java.time.LocalDate;
import java.util.HashMap;

import static org.example.City.BERLIN;

public class Main {
    public static void main(String[] args) {

        //Создать вип клиент
        VipClient vipClient = new VipClient("John", "Smith", LocalDate.of(1959, 12, 03));
        vipClient.setAddress(new Address(BERLIN, 12));
        vipClient.setActive(true);

        //Создать 2 стандартных
        StandardClient standardClientOne = new StandardClient("Mary", "Watson", LocalDate.of(1963, 8, 23));
        standardClientOne.setActive(true);
        standardClientOne.setAddress(new Address(BERLIN, 58));
        Client standardClientTwo = new StandardClient("Nik", "Niklson", LocalDate.of(1968, 8, 19));

        //Посчитать сумму подарка для стандартного клиента
        System.out.println(standardClientOne.calculateClientPresent());

        //Посчитать сумму подарка для вип клиента
        System.out.println(vipClient.calculateClientPresent());

        //Вип клиент оплатил 01 января 2024 1000
        PaidCard paidCardVip = new PaidCard();
        vipClient.setPaidCard(paidCardVip);
        HashMap<LocalDate, Integer> paymentMap = new HashMap<>();
        paymentMap.put(LocalDate.of(2024, 1, 1), 1000);
        paidCardVip.setPaidMoney(paymentMap);

        //Вип клиент оплатил 15 марта 2024 1000
        paymentMap.put(LocalDate.of(2024, 3, 15), 1000);
        paidCardVip.setPaidMoney(paymentMap);

        //Стандартный  клиент оплатил 15 декабря  2022 500
        PaidCard paidCardStandard = new PaidCard();
        standardClientOne.setPaidCard(paidCardStandard);
        HashMap<LocalDate, Integer> paymentMapStandard = new HashMap<>();
        paymentMapStandard.put(LocalDate.of(2022, 12, 15), 500);
        paidCardStandard.setPaidMoney(paymentMapStandard);

        //Стандартный  клиент оплатил 19 декабря  2022 500
        paymentMapStandard.put(LocalDate.of(2022, 12, 19), 500);
        paidCardStandard.setPaidMoney(paymentMapStandard);

        //Должник ли вип клиент?
        DebtService debtService = new DebtService();
        System.out.println(debtService.isDebtorByCard(paidCardVip));

        //Должник ли стандартный клиент?
        System.out.println(debtService.isDebtorByCard(paidCardStandard));

        //Может ли списать долги аип клиенту?
        System.out.println(debtService.cancelDebts(vipClient));

        //Может ли списать долги стандартному клиенту?
        System.out.println(debtService.cancelDebts(standardClientOne));

        //Создать сотрудника
        Employee employee = new Employee("Max", "Maximchuk", LocalDate.of(1997, 4, 11));

        //Нужна ли страховка сотруднику?
        System.out.println(employee.needMedicalInsurance());

        //Нужна ли страховка вип клиенту?
        System.out.println(vipClient.needMedicalInsurance());

        //Нужна ли страховка стандартному клиенту?
        System.out.println(standardClientOne.needMedicalInsurance());

    }
}