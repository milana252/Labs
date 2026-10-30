package org.example;

public class Main {
    public static void main(String[] args) {
        BoardGame bg1 = new BoardGame("Монополия", 4);
        BoardGame bg2 = new BoardGame("Шахматы", 2);
        BoardGame bg3 = new BoardGame("Каркассон", 5);

        VideoGame vg1 = new VideoGame("Cyberpunk 2077", "PC");
        VideoGame vg2 = new VideoGame("Spider-Man", "PlayStation 5");

        Playable[] games = { bg1, bg2, bg3, vg1, vg2 };

        System.out.println("Играем");
        for (Playable game : games) {
            game.play();
            game.pause();
            game.stop();
            System.out.println();
        }

        System.out.println("Сохраняем");
        for (Playable game : games) {
            if (game instanceof Saveable) {
                ((Saveable) game).save();
            }
        }
    }
}