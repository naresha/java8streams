package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) throws IOException{
        Path path = Paths.get("./sample.txt");
        List<String> lines = Files.readAllLines(path);
        lines.forEach(System.out::println);

        System.out.println(lines.stream()
                .flatMap(line -> Arrays.asList(line.split(" ")).stream())
                .map(word -> word.toLowerCase())
                //.map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                //.collect(Collectors.toMap(e->e.getKey(), e->e.getValue(),
                //        (count1, count2) -> count1 + count2)));
                .collect(Collectors.groupingBy(word -> word,
                        Collectors.counting() )));

    }
}
