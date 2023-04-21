package ru.dankras.CustomerCashSelector;

import ru.dankras.model.Cash;

import java.util.List;

public interface CashSelector {
    Cash selectCash(List<Cash> cashes);
}
