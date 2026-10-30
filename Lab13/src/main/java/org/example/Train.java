package org.example;

public class Train {
    private String number;
    private String route;
    private int cars;
    private int seats;
    private double speed;
    private int soldTickets;

    public Train(String number, String route, int cars, int seats, double speed)
            throws InvalidTrainDataException {
        setNumber(number);
        setRoute(route);
        setCars(cars);
        setSeats(seats);
        setSpeed(speed);
        this.soldTickets = 0;
    }

    public void setNumber(String number) throws InvalidTrainDataException {
        if (number == null || number.isEmpty()) {
            throw new InvalidTrainDataException("Номер поезда не может быть пустым");
        }
        this.number = number;
    }

    public void setRoute(String route) throws InvalidTrainDataException {
        if (route == null || route.isEmpty()) {
            throw new InvalidTrainDataException("Маршрут не может быть пустым");
        }
        this.route = route;
    }

    public void setCars(int cars) throws InvalidTrainDataException {
        if (cars <= 0) {
            throw new InvalidTrainDataException("Количество вагонов должно быть больше 0");
        }
        this.cars = cars;
    }

    public void setSeats(int seats) throws InvalidTrainDataException {
        if (seats <= 0) {
            throw new InvalidTrainDataException("Количество мест должно быть больше 0");
        }
        this.seats = seats;
    }

    public void setSpeed(double speed) throws InvalidTrainDataException {
        if (speed <= 0) {
            throw new InvalidTrainDataException("Скорость должна быть больше 0");
        }
        this.speed = speed;
    }

    public void buyTicket() throws TicketException {
        int totalSeats = cars * seats;
        if (soldTickets >= totalSeats) {
            throw new TicketException("Нет свободных мест на поезд " + number);
        }
        soldTickets++;
        System.out.println("Билет куплен на поезд " + number
                + ". Продано: " + soldTickets + "/" + totalSeats);
    }

    public void cancelTicket() throws TicketException {
        if (soldTickets <= 0) {
            throw new TicketException("Нет проданных билетов для отмены на поезд " + number);
        }
        soldTickets--;
        System.out.println("Билет отменён на поезд " + number
                + ". Продано: " + soldTickets + "/" + (cars * seats));
    }

    public String getNumber() {
        return number;
    }

    public String getRoute() {
        return route;
    }

    public int getCars() {
        return cars;
    }

    public int getSeats() {
        return seats;
    }

    public double getSpeed() {
        return speed;
    }

    public int getSoldTickets() {
        return soldTickets;
    }

    @Override
    public String toString() {
        return "Train{" + number + ", " + route + ", вагонов=" + cars
                + ", мест=" + seats + ", скорость=" + speed + "}";
    }
}