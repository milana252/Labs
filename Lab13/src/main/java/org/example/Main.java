package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Train> trains = new ArrayList<>();

    public static Train find(String number) throws TrainNotFoundException {
        for (Train t : trains) {
            if (t.getNumber().equalsIgnoreCase(number)) {
                return t;
            }
        }
        throw new TrainNotFoundException("Поезд не найден: " + number, number);
    }

    public static void main(String[] args) {
        try {
            trains.add(new Train("001A", "Минск - Москва", 10, 54, 120.0));
            trains.add(new Train("002Б", "Минск - Гомель", 6, 40, 100.0));
            trains.add(new Train("003В", "Брест - Витебск", 8, 36, 90.0));
        } catch (InvalidTrainDataException e) {
            System.out.println("Ошибка создания: " + e.getMessage());
        }

        System.out.println("Поезда:");
        for (Train t : trains) {
            System.out.println(t);
        }

        System.out.println("Покупка билетов:");
        try {
            find("001A").buyTicket();
            find("001A").buyTicket();
            find("002Б").buyTicket();
        } catch (TrainNotFoundException e) {
            System.out.println(e.getMessage() + ", номер: " + e.getNumber());
        } catch (TicketException e) {
            System.out.println("Ошибка билета: " + e.getMessage());
        } finally {
            System.out.println("Операция покупки завершена");
        }

        System.out.println("Отмена билета:");
        try {
            find("001A").cancelTicket();
        } catch (TrainNotFoundException e) {
            System.out.println(e.getMessage() + ", номер: " + e.getNumber());
        } catch (TicketException e) {
            System.out.println("Ошибка билета: " + e.getMessage());
        } finally {
            System.out.println("Операция отмены завершена");
        }

        System.out.println("Несуществующий поезд:");
        try {
            find("999X").buyTicket();
        } catch (TrainNotFoundException e) {
            System.out.println(e.getMessage() + ", номер: " + e.getNumber());
        } catch (TicketException e) {
            System.out.println("Ошибка билета: " + e.getMessage());
        } finally {
            System.out.println("Операция завершена");
        }

        System.out.println("Отмена без проданных билетов:");
        try {
            find("003В").cancelTicket();
        } catch (TrainNotFoundException e) {
            System.out.println(e.getMessage() + ", номер: " + e.getNumber());
        } catch (TicketException e) {
            System.out.println("Ошибка билета: " + e.getMessage());
        } finally {
            System.out.println("Операция завершена");
        }
    }
}