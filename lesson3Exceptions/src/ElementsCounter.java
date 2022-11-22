import java.lang.reflect.Array;
import java.util.*;

public class ElementsCounter<K> {
    public static void addElement(Object[] array, int size, Random random) {
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
    }

    public static <K> Map<K, Integer> arrayToMap(K[] array) {
        Map<K, Integer> map = new HashMap<>();
        for (K key : array) {
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            map.put(key, map.get(key).intValue() + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        int size = 1000;
        var array = (Integer[]) Array.newInstance(Integer.class, size);
        Random random = new Random();
        addElement(array, size, random);
        Map<Integer, Integer> map = arrayToMap(array);
        System.out.println(map);

    }
}
