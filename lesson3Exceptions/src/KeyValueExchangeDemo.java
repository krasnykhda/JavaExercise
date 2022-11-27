import java.util.*;

public class KeyValueExchangeDemo {
    public static <K, V> Map<V, Collection<K>> exchangeKeyValue(Map<K, V> map) {
        Map<V, Collection<K>> newMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (newMap.get(entry.getValue()) == null) {
                newMap.put(entry.getValue(), new ArrayList<>());
            }
            newMap.get(entry.getValue()).add(entry.getKey());

        }
        return newMap;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "2+");
        map.put(3, "4+");
        map.put(5, "6+");
        map.put(7, "8+");
        map.put(9, "8+");
        System.out.println(map);
        System.out.println(exchangeKeyValue(map));
    }
}
