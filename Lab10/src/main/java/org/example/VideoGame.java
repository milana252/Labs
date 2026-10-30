package org.example;

class VideoGame implements Playable, Saveable {
    private String name;
    private String platform;
    private boolean saved;

    public VideoGame(String name, String platform) {
        this.name = name;
        this.platform = platform;
        this.saved = false;
    }

    @Override
    public void play() {
        System.out.println("Запускаем видеоигру: " + name + " на платформе " + platform);
    }

    @Override
    public void pause() {
        System.out.println("Пауза в видеоигре " + name);
    }

    @Override
    public void stop() {
        System.out.println("Вышли из видеоигры " + name);
    }

    @Override
    public void save() {
        saved = true;
        System.out.println("Прогресс в видеоигре " + name + " сохранен.");
    }

    @Override
    public void load() {
        System.out.println("Видеоигра " + name + " загружена.");
    }
}
