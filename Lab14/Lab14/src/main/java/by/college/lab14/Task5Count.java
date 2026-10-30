package by.college.lab14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task5Count {

    public static void main(String[] args) throws IOException {
        run(Path.of("files"));
    }

    public static void run(Path baseDir) throws IOException {
        Path dir = baseDir.resolve("task5");
        Files.createDirectories(dir);
        Path file = dir.resolve("f.txt");

        Random random = new Random();
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lines.add(String.valueOf(random.nextInt(101)));
        }
        Files.write(file, lines, StandardCharsets.UTF_8);

        int count = 0;
        for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            if (Integer.parseInt(line.trim()) > 60) {
                count++;
            }
        }
        System.out.println("Количество чисел, больших 60: " + count);
    }
}
