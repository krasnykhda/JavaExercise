package ru.dankras;

import ru.dankras.CustomerCashSelector.BabyCashSelector;
import ru.dankras.CustomerCashSelector.CashSelector;
import ru.dankras.CustomerCashSelector.MansCashSelector;
import ru.dankras.CustomerCashSelector.WomansCashSelector;
import ru.dankras.model.Customer;
import ru.dankras.model.CustomerType;

import java.util.Random;

public class CustomerFactory {
    private static int actualId;

    public static Customer getCustomer(Random random) {
        int pursheCount = random.nextInt(10) + 1;
        CustomerType customerType = CustomerType.values()[random.nextInt(CustomerType.values().length)];
        Customer customer = new Customer(pursheCount, customerType, getCashSelector(customerType));
        customer.setJustComeIn(true);
        customer.setId(actualId);
        actualId++;
        return customer;
    }

    private static CashSelector getCashSelector(CustomerType customerType) {
        switch (customerType) {
            case MAN:
                return new MansCashSelector();
            case WOMEN:
                return new WomansCashSelector();
            default:
                return new BabyCashSelector();
        }

    }
}
