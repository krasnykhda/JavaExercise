import java.util.*;
import java.util.stream.Collectors;

public class CollectionsWithoutDublicateDemo {
    public static <T> Collection collectionsWithoutDublicate(Collection<T> list) {
        return (Collection<T>) list.stream().collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(20));
        }
        var set = collectionsWithoutDublicate(list);
        System.out.println(list);
        System.out.println(set);
    }
}
