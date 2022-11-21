package anonymousClasses;

public class Food {


    public void prepare(Cookable cookable, String str) {
        cookable.cook(str);
    }

    public static void main(String[] args) {
        new Food().prepare(new Cookable() {
            @Override
            public void cook(String str) {
                System.out.println(str + " готов");
            }
        }, "Салат");

    }
}
