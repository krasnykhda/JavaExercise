public class MaxLengthStringDemo {
    public static void main(String[] args) {
        BinaryOperator<String> stringWithMaxLength = (str1, str2) -> {
            if (str2.length() > str1.length()) {
                return str2;
            } else {
                return str1;
            }
        };
        System.out.println(stringWithMaxLength.apply("asd", "1234"));
    }
}
