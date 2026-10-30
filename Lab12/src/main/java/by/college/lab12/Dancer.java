package by.college.lab12;

import java.util.List;

public class Dancer {

    private int id;
    private String name;
    private String style;
    private int level;
    private List<Integer> competitionScores;

    public Dancer(int id, String name, String style, int level, List<Integer> competitionScores) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.level = level;
        this.competitionScores = competitionScores;
    }

    public double getAverageScore() {
        if (competitionScores == null || competitionScores.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int score : competitionScores) {
            sum += score;
        }
        return sum / competitionScores.size();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Integer> getCompetitionScores() {
        return competitionScores;
    }

    @Override
    public String toString() {
        return "Dancer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", level=" + level +
                ", competitionScores=" + competitionScores +
                ", averageScore=" + String.format("%.2f", getAverageScore()) +
                '}';
    }
}
