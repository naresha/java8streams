package demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Streams2 {
    public static final String FILE_PATH = "./sample.txt";

    public static void main(String[] args) throws Exception{

        Path path = Paths.get(FILE_PATH);
        System.out.println(Files.readAllLines(path)
                .stream()
                .map(line -> Arrays.asList(line.split(" ")).stream())
                .flatMap(Function.identity())
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                //.collect(toMap(e -> e.getKey(), e -> e.getValue(), (a, b) -> (a + b)))
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()))

        );

    }
}
