package by.college.lab14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.List;

public class Task1Store {

    public static void main(String[] args) throws IOException {
        run(Path.of("files"));
    }

    public static void run(Path baseDir) throws IOException {
        Path dir = baseDir.resolve("task1");
        Files.createDirectories(dir);
        Path file = dir.resolve("store.txt");

        List<String> storeInfo = List.of(
                "Магазин: Книжный дом \"Знание\"",
                "Адрес: г. Минск, пр. Независимости, 15",
                "Телефон: +375 (17) 123-45-67",
                "Время работы: 09:00 - 21:00",
                "Ассортимент: книги, учебники, канцелярия"
        );
        Files.write(file, storeInfo, StandardCharsets.UTF_8);

        System.out.println("Данные о файле:");
        System.out.println("Имя: " + file.getFileName());
        System.out.println("Путь: " + file.toAbsolutePath());
        System.out.println("Размер: " + Files.size(file) + " байт");
        System.out.println("Существует: " + Files.exists(file));
        System.out.println("Доступен для чтения: " + Files.isReadable(file));
        FileTime modified = Files.getLastModifiedTime(file);
        System.out.println("Изменён: " + modified);

        System.out.println("Информация из файла:");
        for (String line : Files.readAllLines(file, StandardCharsets.UTF_8)) {
            System.out.println(line);
        }
        System.out.println();
    }
}
