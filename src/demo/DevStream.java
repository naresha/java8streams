package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DevStream {
    private static List<Developer> createDevs() {
        List<Developer> developers = new ArrayList<>();
        developers.add(
                new Developer(
                        "Mark",
                        35,
                        Arrays.asList("Java", "JavaScript")
                )
        );
        developers.add(
                new Developer("Raj", 30,
                        Arrays.asList("Java", "Groovy", "JavaScript"))
        );
        developers.add(
                new Developer("Reema", 26, Arrays.asList("JavaScript", "Groovy"))
        );
        return developers;
    }

    public static void main(String[] args) throws IOException {
        List<Developer> devs = createDevs();
        System.out.println(devs);

        List<String> names = devs.stream()
                .map(dev -> dev.getName())
                .peek(name -> System.out.println("mapped " + name))
                .collect(Collectors.toList());
        System.out.println(names);

        List<Integer> ages = devs.stream()
                .map(Developer::getAge)
                .collect(Collectors.toList());
        System.out.println(ages);

        Optional<Developer> devOlderThan50 = devs.stream()
                .filter(dev -> dev.getAge() > 50)
                //.collect(Collectors.toList());
                .findFirst();

        System.out.println(devOlderThan50);
        System.out.println(devOlderThan50.isPresent());

        System.out.println(Stream.<Optional<Integer>>of(Optional.of(10), Optional.of(20), Optional.empty())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(value -> value > 10)
                .collect(Collectors.toList()));




    }

}
