package org.example;

public class TrainNotFoundException extends Exception {
    private String number;

    public TrainNotFoundException(String message, String number) {
        super(message);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
