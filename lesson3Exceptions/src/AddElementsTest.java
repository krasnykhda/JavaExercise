import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AddElementsTest {
    public static void addElement(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    public static Integer getRandomElement(List<Integer> list, Random random, int size) {
        return list.get(random.nextInt(size));
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        var t1 = System.currentTimeMillis();
        addElement(arrayList, 20000000);
        var t2 = System.currentTimeMillis();
        System.out.println("Время заполнения ArrayList " + (t2 - t1) + " миллисекунд");
        List<Integer> linkedList = new LinkedList<Integer>();
        t1 = System.currentTimeMillis();
        addElement(linkedList, 20000000);
        t2 = System.currentTimeMillis();
        System.out.println("Время заполнения LinkedList " + (t2 - t1) + " миллисекунд");
        System.out.println("Время заполнения LinkedList в конец списка существенно больше времени ArrayList" + "\n" +
                "так как операции выделения памяти в LinkedList происходят на каждой итерации и они затратны. В ArrayList выделение памяти осуществляется" + "\n" +
                "при превышнии объема текущего массива, что происходит намного реже ");
        Random random = new Random();
        t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Integer value = getRandomElement(arrayList, random, 100000);
        }
        t2 = System.currentTimeMillis();
        System.out.println("" +
                "\nВремя получения элементов ArrayList " + (t2 - t1) + " миллисекунд");

        t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Integer value = getRandomElement(linkedList, random, 100000);
        }
        t2 = System.currentTimeMillis();
        System.out.println("Время получения элементов LinkedList " + (t2 - t1) + " миллисекунд\n");
        System.out.println("Время получения LinkedList на порядки больше ArrayList, так как для получения случайного элемента\n" +
                "в LinkedList нужно пройти по всем элементам от начала или конца. В ArrayList элемент получается сразу");
    }
}
