package by.college.lab14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2Numbers {

    public static void main(String[] args) throws IOException {
        run(Path.of("files"), new Scanner(System.in));
    }

    public static void run(Path baseDir, Scanner scanner) throws IOException {
        Path dir = baseDir.resolve("task2");
        Files.createDirectories(dir);
        Path file = dir.resolve("f.txt");

        List<String> lines = new ArrayList<>();
        System.out.println("Введите 10 целых чисел:");
        for (int i = 1; i <= 10; i++) {
            System.out.print("Число " + i + ": ");
            lines.add(String.valueOf(scanner.nextInt()));
        }
        Files.write(file, lines, StandardCharsets.UTF_8);

        int count = 0;
        System.out.println("Числа из файла:");
        for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            int number = Integer.parseInt(line.trim());
            System.out.print(number + " ");
            if (number % 4 == 0 && number % 8 != 0) {
                count++;
            }
        }
        System.out.println();
        System.out.println("Количество чисел, кратных 4 и не кратных 8: " + count);
    }
}
