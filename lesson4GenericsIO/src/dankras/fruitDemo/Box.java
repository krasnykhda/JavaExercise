package dankras.fruitDemo;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits;

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public T getFruit() {
        return fruits.remove(fruits.size() - 1);
    }

    public int getSize() {
        return fruits.size();
    }

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public float getWeight() {
        if (fruits.size() > 0) {
            return fruits.get(0).getWeight() * fruits.size();
        } else {
            return 0;
        }

    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }


}
