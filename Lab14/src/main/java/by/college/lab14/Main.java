package by.college.lab14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Path BASE_DIR = Path.of("files");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Files.createDirectories(BASE_DIR);
            Task1Store.run(BASE_DIR);
            Task2Numbers.run(BASE_DIR, scanner);
            Task3Files.run(BASE_DIR);
            Task4Speed.run(BASE_DIR, scanner);
            Task5Count.run(BASE_DIR);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось число");
        } finally {
            scanner.close();
        }
    }
}
