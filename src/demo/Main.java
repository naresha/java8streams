package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> doubles = doubleNumbers(numbers);
        List<Integer> greaterThan5 = filterGreaterThan5(doubles);
        System.out.println(numbers);
        System.out.println(doubles);
        System.out.println(greaterThan5);

        Function<Integer, Integer> doubleNumber = number -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Doubling " + number);
            return number * 2;
        };
        Predicate<Integer> isGreaterThan5 = number -> {
            System.out.println("Checking if " + number + " is greater than 5");
            return number > 5;
        };

        /*
        Integer result = numbers.stream()
                .map(doubleNumber)
                .filter(isGreaterThan5)
                .findFirst().get();
                */
        //System.out.println(result);
        List<Integer> result = numbers.parallelStream()
                .map(doubleNumber)
                .collect(Collectors.toList());
        System.out.println(result);

        List<Person> people = Arrays.asList(
                new Person("Raj", 35),
                new Person("Reema", 20),
                new Person("Mark", 40)
        );
        List<String> names = people.stream()
                            .filter(person -> person.getName().length() >= 4)
                            .map(Person::getName)
                            .map(String::toUpperCase)
                .collect(Collectors.toList());
        //System.out.println(names);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        List<Integer> doubles = new ArrayList<>();
        numbers.forEach(number -> {
            Integer doubleValue = number * 2;
            doubles.add(doubleValue);
        });
        return doubles;
    }

    public static List<Integer> filterGreaterThan5(List<Integer> numbers) {
        List<Integer> filtered = new ArrayList<>();
        numbers.forEach(number -> {
            if (number > 5) {
                filtered.add(number);
            }
        });
        return filtered;
    }

    public static String getProperty(Function<Person, String> mapper, Person person) {
        return mapper.apply(person);
    }


}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
