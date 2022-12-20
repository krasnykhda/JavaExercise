package ru.dankras.CustomerCashSelector;

import ru.dankras.model.Cash;

import java.util.List;

public class WomansCashSelector implements CashSelector {
    @Override
    public Cash selectCash(List<Cash> cashes) {
        int min = Integer.MAX_VALUE;
        Cash minCash = null;
        for (Cash cash : cashes) {
            if (cash.getBlockingQueue().size() < min) {
                min = cash.getBlockingQueue().size();
                minCash = cash;
            }
        }
        return minCash;
    }
}
