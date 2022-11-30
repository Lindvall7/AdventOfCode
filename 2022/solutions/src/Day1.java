import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }



    private static List<Integer> readInput() {
        List<Integer> result;
        String fileName = "input.txt";
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}