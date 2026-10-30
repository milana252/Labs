package by.college.lab12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void printDancers(List<Dancer> dancers, int level) {
        System.out.println("Танцоры с уровнем " + level + ":");
        for (Dancer dancer : dancers) {
            if (dancer.getLevel() == level) {
                System.out.println("ID: " + dancer.getId()
                        + ", имя: " + dancer.getName()
                        + ", средний балл: " + String.format("%.2f", dancer.getAverageScore()));
            }
        }
        System.out.println();
    }

    private static void printList(List<Dancer> dancers) {
        for (Dancer dancer : dancers) {
            System.out.println(dancer);
        }
    }

    public static void main(String[] args) {
        List<Dancer> dancers = new ArrayList<>();

        dancers.add(new Dancer(1, "Анна", "Бальные танцы", 3, List.of(4, 5, 3, 4)));
        dancers.add(new Dancer(2, "Борис", "Хип-хоп", 2, List.of(2, 2, 3, 2)));
        dancers.add(new Dancer(3, "Виктория", "Латиноамериканские танцы", 4, List.of(5, 5, 4, 5)));
        dancers.add(new Dancer(4, "Глеб", "Современные танцы", 1, List.of(2, 1, 2, 1)));
        dancers.add(new Dancer(5, "Дарья", "Бальные танцы", 3, List.of(4, 4, 5, 4)));
        dancers.add(new Dancer(6, "Дмитрий", "Народные танцы", 2, List.of(3, 3, 3, 3)));

        System.out.println("Исходный список:");
        printList(dancers);
        System.out.println();

        Iterator<Dancer> iterator = dancers.iterator();
        while (iterator.hasNext()) {
            Dancer dancer = iterator.next();
            if (dancer.getAverageScore() < 3) {
                iterator.remove();
            }
        }

        System.out.println("После удаления танцоров со средним баллом < 3:");
        printList(dancers);
        System.out.println();

        for (Dancer dancer : dancers) {
            if (dancer.getAverageScore() >= 4 && dancer.getLevel() < 5) {
                dancer.setLevel(dancer.getLevel() + 1);
            }
        }

        System.out.println("После повышения уровня танцоров со средним баллом >= 4:");
        printList(dancers);
        System.out.println();

        printDancers(dancers, 4);
        printDancers(dancers, 5);

        dancers.sort(Comparator
                .comparingDouble(Dancer::getAverageScore)
                .reversed()
                .thenComparing(Dancer::getName));

        System.out.println("Сортировка по убыванию среднего балла, при совпадении - по имени:");
        for (Dancer dancer : dancers) {
            System.out.println("ID: " + dancer.getId()
                    + ", имя: " + dancer.getName()
                    + ", средний балл: " + String.format("%.2f", dancer.getAverageScore()));
        }
    }
}
