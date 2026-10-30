package by.college.lab14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Task4Speed {

    public static void run(Path baseDir, Scanner scanner) throws IOException {
        Path dir = baseDir.resolve("task4");
        Files.createDirectories(dir);
        Path file = dir.resolve("speed.txt");

        List<String> lines = new ArrayList<>();
        System.out.println("Введите 15 значений скорости интернета (Мбит/с):");
        for (int i = 1; i <= 15; i++) {
            System.out.print("Значение " + i + ": ");
            double value = scanner.nextDouble();
            lines.add(String.valueOf(value));
        }
        Files.write(file, lines, StandardCharsets.UTF_8);

        double sum = 0;
        int count = 0;
        for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            sum += Double.parseDouble(line.trim());
            count++;
        }
        double average = count == 0 ? 0 : sum / count;
        System.out.printf(Locale.US, "Средняя скорость: %.2f Мбит/с%n", average);
        System.out.println();
    }
}
