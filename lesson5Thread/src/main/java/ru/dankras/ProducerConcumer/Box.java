package ru.dankras.ProducerConcumer;

public class Box {
    private int value;
    private boolean isFree;

    public boolean isFree() {
        return isFree;
    }

    public int getValueAndFree() {
        isFree=true;
        return value;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        isFree=false;
        this.value=value;
    }
}
