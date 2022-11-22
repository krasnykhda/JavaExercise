package ru.dankras.fruitDemo;

public class FruitsManager {
    public static <T extends Fruit> void pourOver(Box<T> boxFrom, Box<T> boxTo) {
        while (boxFrom.getSize() > 0) {
            boxTo.addFruit(boxFrom.getFruit());
        }
    }

    public static void main(String[] args) {
        Box<Apple> boxApple = new Box<>();
        boxApple.addFruit(new Apple());
        boxApple.addFruit(new Apple());
        boxApple.addFruit(new Apple());
        System.out.println(boxApple.getWeight());

        Box<Apple> boxApple2 = new Box<>();
        boxApple2.addFruit(new Apple());
        boxApple2.addFruit(new Apple());
        boxApple2.addFruit(new Apple());

        Box<Orange> boxOrange = new Box<>();
        boxOrange.addFruit(new Orange());
        boxOrange.addFruit(new Orange());
        boxOrange.addFruit(new Orange());
        System.out.println(boxOrange.getWeight());
        System.out.println(boxApple.compare(boxOrange));

        pourOver(boxApple, boxApple2);

        System.out.println(boxApple.getWeight());
        System.out.println(boxApple2.getWeight());

    }
}
