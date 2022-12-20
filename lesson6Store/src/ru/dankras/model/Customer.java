package ru.dankras.model;

import ru.dankras.CustomerCashSelector.CashSelector;

import java.util.List;

public class Customer {
    private final CustomerType customerType;
    private int id;
    private int purscheCount;


    private boolean isJustComeIn;
    private final CashSelector cashSelector;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPurscheCount() {
        return purscheCount;
    }

    public void setJustComeIn(boolean justComeIn) {
        isJustComeIn = justComeIn;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public Cash getCash(List<Cash> cashes) {
        return cashSelector.selectCash(cashes);
    }

    public void setPurscheCount(int purscheCount) {
        this.purscheCount = purscheCount;
    }

    public Customer(int purscheCount, CustomerType customerType, CashSelector cashSelector) {
        this.purscheCount = purscheCount;
        this.customerType = customerType;
        this.isJustComeIn = false;
        this.cashSelector = cashSelector;
    }

}
