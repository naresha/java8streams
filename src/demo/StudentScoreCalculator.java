package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentScoreCalculator {
    public static void main(String[] args) throws IOException {

        Function<List<String>, Student> toStudent = (tokens) -> {
            Student student = new Student();
            student.setId(Long.valueOf(tokens.get(0)));
            student.setName(tokens.get(1));
            student.setScore1(Integer.valueOf(tokens.get(2)));
            student.setScore2(Integer.valueOf(tokens.get(3)));
            student.setScore3(Integer.valueOf(tokens.get(4)));
            return student;
        };

        Path path = Paths.get("./scores.csv");
        List<String> lines = Files.readAllLines(path);
        List<Student> students = lines.stream()
                .skip(1)
                .map(line -> Arrays.asList(line.split(",")))
                .map(toStudent)
                .collect(Collectors.toList());
        System.out.println(students);


        List<Function<Student, Integer>> functions =
                Arrays.asList(Student::getScore1, Student::getScore2,
                        Student::getScore3);

        Function<Function<Student, Integer>, OptionalDouble> averageCalculator =
                (function) -> {
                    return students.stream()
                            .map(function)
                            .mapToInt(value -> Integer.valueOf(value))
                            .average();
                };

        List<OptionalDouble> result = functions.stream()
                .map(averageCalculator)
                .collect(Collectors.toList());
        System.out.println(result);


    }
}
