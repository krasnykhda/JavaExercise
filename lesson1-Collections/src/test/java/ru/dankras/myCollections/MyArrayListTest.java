package ru.dankras.myCollections;

import org.junit.jupiter.api.*;



public class MyArrayListTest {
    private MyList<Integer> myList;

    @Test
    @DisplayName("должен бросать верное исключение при получении элемента по некорректному индексу")
    void indexOutTest() {

        for (int i = 0; i < 50; i++) {
            myList.add(i,0);
        }
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> myList.get(50));

    }
    @Test
    @DisplayName("Должен давать верное количество элементов после заполнения")
    void sizeListTest() {
        for (int i = 0; i < 50; i++) {
            myList.add(i,0);
        }
       Assertions.assertEquals(50,myList.size());

    }
    @Test
    @DisplayName("Должен давать верное количество элементов после удаления")
    void sizeListTestAfterDelete() {
        for (int i = 0; i < 50; i++) {
            myList.add(i,0);
        }
        for (int i = 0; i < 30; i++) {
            myList.remove(0);
        }
        Assertions.assertEquals(20,myList.size());

    }
    @Test
    @DisplayName("Должен правильно определять элементы списка")
    void getElementsTest() {
        for (int i = 0; i < 50; i++) {
            myList.add(i,0);
        }
        Assertions.assertEquals(49,myList.get(0));
        Assertions.assertEquals(0,myList.get(49));
        Assertions.assertEquals(40,myList.get(9));


    }
    @Test
    @DisplayName("Должен правильно очищать список")
    void deleteListTest() {
        for (int i = 0; i < 50; i++) {
            myList.add(i,0);
        }
        for (int i = 0; i < 50; i++) {
            myList.remove(0);
        }
        Assertions.assertEquals(0,myList.size());

    }
    @BeforeEach
    void setUp() {
            myList = new MyArrayList<Integer>();
    }
}
