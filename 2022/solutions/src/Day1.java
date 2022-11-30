import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
    public static void main(String[] args) {

        List<Integer> input = readInput();
        System.out.println(input);
    }



    private static List<Integer> readInput() {
        List<Integer> result;
        String fileName = "day1input.txt";
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