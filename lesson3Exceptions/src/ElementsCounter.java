import java.util.*;

public class ElementsCounter {
    public static void addElement(List<Integer> list, int size, Random random) {
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(30));
        }
    }

    public static Map<Integer, Integer> getCountsOfElementsCollection(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer key : list) {
            if (map.get(key) == null) {
                map.put(key, 0);
            }
            map.put(key, map.get(key).intValue() + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();
        addElement(arrayList, 1000, random);
        Map<Integer, Integer> map = getCountsOfElementsCollection(arrayList);
        System.out.println(map);

    }
}
