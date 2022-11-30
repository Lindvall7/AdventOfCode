import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String file_name = "input.txt";
        Path path = Path.of(file_name);

        long lineCount;
        try(Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
          lineCount = stream.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean[] increased = new boolean[(int)lineCount];

        try (BufferedReader bufferedReader = Files.newBufferedReader(path);) {
            String line = bufferedReader.readLine();
            int count = 0;
            while (line != null) {
                String currentLine = line;
                line = bufferedReader.readLine();
                int val1;
                int val2;
                if(line != null) {
                    val1 = Integer.parseInt(currentLine);
                    val2 = Integer.parseInt(line);
                    increased[count] = (val2 > val1);
                }
                count++;
            }
            int nbrOfIncreases = 0;
            for (boolean haveIncreased: increased) {
                if(haveIncreased) {
                    nbrOfIncreases++;
                }
            }
            System.out.println(nbrOfIncreases);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}