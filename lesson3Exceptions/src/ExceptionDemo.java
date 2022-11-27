public class ExceptionDemo {
    public static int getAccOfElements(Object[][] mass) throws MyArraySizeException, MyArrayDataException {
        if (mass.length != 4) {
            throw new MyArraySizeException("Некорректный размер массива");
        }
        int acc = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i].length != 4) {
                throw new MyArraySizeException("Некорректный размер массива ");
            }
            for (int j = 0; j < mass[i].length; j++) {
                if (mass[i][j] instanceof Integer) {
                    acc += (Integer) mass[i][j];
                } else {
                    throw new MyArrayDataException("Некорректные данные в ячейке " + (i) + ", " + j);
                }


            }
        }
        return acc;
    }

    public static void main(String[] args) {
        Object[][] mass = {{1, 1, 1, 1}, {2, 2, 2, 4}, {3, 3, 3, 4}, {4, 4, 4, 4}};
        int acc = 0;
        try {
            acc = getAccOfElements(mass);
            System.out.println(acc);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.err.println(exception.getMessage());
        }


    }
}
