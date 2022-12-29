package ru.dankras.CustomerCashSelector;

import ru.dankras.model.Cash;

import java.util.List;

public class MansCashSelector implements CashSelector {
    @Override
    public Cash selectCash(List<Cash> cashes) {
        int minTime=1000000;
        Cash minCash=null;
        for (Cash cash:cashes){
            if(cash.getNumberProduct()/cash.getSpeed()<minTime){
                minCash=cash;
                minTime=cash.getNumberProduct()/cash.getSpeed();
            }
        }
        return minCash;
    }
}
