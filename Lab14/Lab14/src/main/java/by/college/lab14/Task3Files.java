package by.college.lab14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task3Files {

    public static void main(String[] args) throws IOException {
        run(Path.of("files"));
    }

    public static void run(Path baseDir) throws IOException {
        Path dir = baseDir.resolve("task3");
        Files.createDirectories(dir);
        Path f = dir.resolve("f.txt");
        Path g = dir.resolve("g.txt");
        Path h = dir.resolve("h.txt");

        Random random = new Random();
        List<String> fLines = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            fLines.add(String.valueOf(random.nextInt(201) - 100));
        }
        Files.write(f, fLines, StandardCharsets.UTF_8);

        List<String> gLines = new ArrayList<>();
        List<String> hLines = new ArrayList<>();
        for (String line : Files.readAllLines(f, StandardCharsets.UTF_8)) {
            int number = Integer.parseInt(line.trim());
            if (number % 9 == 0 && number % 2 != 0) {
                gLines.add(String.valueOf(number));
            } else {
                hLines.add(String.valueOf(number));
            }
        }

        Files.write(g, gLines, StandardCharsets.UTF_8);
        Files.write(h, hLines, StandardCharsets.UTF_8);
    }
}
