import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayElementsSwapper {
    public static void swapElement(Object[]array,int indexFirst,int indexSecond){
       var elementOld=array[indexFirst];
       array[indexFirst]=array[indexSecond];
       array[indexSecond]=elementOld;
    }

    public static void main(String[] args) {
        Integer[] arr={1,2,3,4,5};
        Arrays.stream(arr).forEach(System.out::print);
        swapElement(arr,1,2);
        System.out.println("\n");
        Arrays.stream(arr).forEach(System.out::print);


    }
}
