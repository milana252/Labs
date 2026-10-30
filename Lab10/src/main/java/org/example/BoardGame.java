package org.example;

class BoardGame implements Playable, Saveable {
    private String name;
    private int players;
    private boolean saved;

    public BoardGame(String name, int players) {
        this.name = name;
        this.players = players;
        this.saved = false;
    }

    @Override
    public void play() {
        System.out.println("Играем в настольную игру: " + name + " (Игроков: " + players + ")");
    }

    @Override
    public void pause() {
        System.out.println("Пауза в настольной игре " + name);
    }

    @Override
    public void stop() {
        System.out.println("Закончили играть в " + name);
    }

    @Override
    public void save() {
        saved = true;
        System.out.println("Настольная игра " + name + " сохранена.");
    }

    @Override
    public void load() {
        System.out.println("Настольная игра " + name + " загружена.");
    }
}
