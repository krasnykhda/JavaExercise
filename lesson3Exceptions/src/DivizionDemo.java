public class DivizionDemo {
    public static void main(String[] args) {
        MyPredicate<Integer> check = x -> x % 13 == 0;
        System.out.println(check.test(27));
        System.out.println(check.test(13));
    }

    ;
}

