package streamsDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private int age;
    private  String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        List<Person> personList=new ArrayList<>();
        personList.add(new Person(20,"Вася"));
        personList.add(new Person(35,"Петя"));
        personList.add(new Person(40,"Коля"));
        personList.add(new Person(25,"Оля"));
        personList.add(new Person(21,"Дима"));
        personList.add(new Person(15,"Таня"));
        personList.stream().forEach((person)-> System.out.println(person.getAge()+" "+person.getName()));
        List age30= personList.stream().filter((person -> person.getAge()>30)).collect(Collectors.toList());
        List names=personList.stream().map((person -> person.getName())).collect(Collectors.toList());
        List ages=personList.stream().map((person -> person.getAge())).collect(Collectors.toList());
    }
}
