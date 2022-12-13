import java.util.Arrays;
import java.util.List;

public class ArrayToArrayListConverter {
    public static <T> List<T> convertArrayToArrayList(T array[]){
       return Arrays.asList(array);
    }

    public static void main(String[] args) {
        String[] array={"asd","qwe","123","456"};
        var list= convertArrayToArrayList(array);
        System.out.println(list);
    }
}
