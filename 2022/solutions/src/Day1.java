import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.sql.Timestamp;

public class Day1 {
    public static void main(String[] args) { //"2022-12-21T14:51:36"

        List<String> input = readInputAsString();
        List<Integer> inputAsInt = convertToIntList(input);
        System.out.println(inputAsInt);
        int answerToPart1 = Collections.max(getMostCalories(inputAsInt));
        System.out.println(answerToPart1);
        System.out.println(part2(inputAsInt));
    }

    private static List<Integer> convertToIntList(List<String> strList) {
        List<Integer> results = new ArrayList<Integer>();
        for(String strElement: strList) {
            if(strElement.isBlank()) {
                results.add(0);
            } else {
                results.add(Integer.parseInt(strElement));
            }
        }
        return results;
    }

    private static int part2(List<Integer> input) {
        List<Integer> summedCals = getMostCalories(input);
        List<Integer> topThree = new ArrayList<Integer>();
        for(int i = 1; i <= 3; i++) {
            int max = Collections.max(summedCals);
            topThree.add(max);
            summedCals.remove(summedCals.indexOf(max));
        }

        return topThree.stream()
                .reduce(0, Integer::sum);  // or (i1,i2) ->i1+i2
    }

    private static List<Integer> getMostCalories(List<Integer> input) {
        int lastElf = 0;
        int currentElf = 0;
        List<Integer> summedUpCals = new ArrayList<Integer>();
        while(currentElf < input.size()) {
            if(input.get(currentElf) == 0) {
                int sum = 0;
                for(int i=lastElf;i <= currentElf; i++) {
                    sum+=input.get(i);
                }
                summedUpCals.add(sum);
                lastElf = currentElf;
            }
            currentElf++;
        }
        System.out.println(summedUpCals);

        return summedUpCals;
    }

    private static List<Integer> readInput() {
        List<Integer> result;
        String fileName = "input/day1input1.txt";
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines
                    .map(str -> Integer.parseInt(str))
                    .collect(Collectors.toList());
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<String> readInputAsString() {
        List<String> result;
        String fileName = "input/day1input1.txt";
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines
                    .collect(Collectors.toList());
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}