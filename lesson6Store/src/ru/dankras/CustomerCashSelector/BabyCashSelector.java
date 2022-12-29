package ru.dankras.CustomerCashSelector;

import ru.dankras.model.Cash;

import java.util.List;
import java.util.Random;

public class BabyCashSelector implements CashSelector {
    private static final Random random = new Random();

    @Override
    public Cash selectCash(List<Cash> cashes) {
        return cashes.get(random.nextInt(cashes.size()));
    }
}
