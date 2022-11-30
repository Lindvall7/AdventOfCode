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

        System.out.println(part1(input));
        System.out.println(part2(input));
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

    private static int part1(List<Integer> input) {
        boolean[] haveIncreased = new boolean[input.size()+1];
        for(int i=1;i < input.size();i++) {
            haveIncreased[i] = (input.get(i)) > input.get(i-1);
        }

        int nbrOfIncreases = 0;

        for(boolean b: haveIncreased) {
            if(b) {
                nbrOfIncreases++;
            }
        }
        return nbrOfIncreases;

    }

    private static int part2(List<Integer> input) {
        int[] sums = new int[input.size()-2];
        int sumOfLastThree;
        for(int i=2;i < input.size();i++) {
            sumOfLastThree = input.get(i-2) + input.get(i-1) + input.get(i);
            sums[i-2] = sumOfLastThree;
        }

        int nbrOfIncreases = 0;

        for(int i=1;i < sums.length;i++) {
            if(sums[i] > sums[i-1]) {
                nbrOfIncreases++;
            }
        }
        return nbrOfIncreases;
    }

}
