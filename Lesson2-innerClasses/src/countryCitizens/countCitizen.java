package countryCitizens;

public class countCitizen {
    static int countCitizen = 10000000;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            countCitizen += (countCitizen / 1000) * 6;
        }
        System.out.println(countCitizen);
    }
}
