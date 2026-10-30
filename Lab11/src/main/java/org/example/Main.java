class Bird {
    protected String name;
    protected String species;
    protected double wingspan;

    public Bird(String name, String species, double wingspan) {
        this.name = name;
        this.species = species;
        this.wingspan = wingspan;
    }

    public void fly() {
        System.out.println(name + ": Лечу");
    }

    public void fly(int distance) {
        System.out.println(name + ": Лечу " + distance + " км");
    }

    public void fly(double height) {
        System.out.println(name + ": Лечу на высоте " + height);
    }

    public String getFlightStyle() {
        return "Обычный полет";
    }
}

class Eagle extends Bird {
    private double diveSpeed;

    public Eagle(String name, String species, double wingspan, double diveSpeed) {
        super(name, species, wingspan);
        this.diveSpeed = diveSpeed;
    }

    @Override
    public String getFlightStyle() {
        return "Парящий полет";
    }

    public void hunt() {
        System.out.println(name + ": Охочусь");
    }

    public void hunt(String prey) {
        System.out.println(name + ": Охочусь на " + prey);
    }

    public void hunt(String prey, int altitude) {
        System.out.println(name + ": Охочусь на " + prey + " с высоты " + altitude + " м");
    }
}

class Sparrow extends Bird {
    private int chirpFrequency;

    public Sparrow(String name, String species, double wingspan, int chirpFrequency) {
        super(name, species, wingspan);
        this.chirpFrequency = chirpFrequency;
    }

    @Override
    public String getFlightStyle() {
        return "Порхающий полет";
    }

    public void chirp() {
        System.out.println(name + ": Чирикаю");
    }

    public void chirp(int times) {
        System.out.println(name + ": Чирикаю " + times + " раз");
    }

    public void chirp(String song, int times) {
        System.out.println(name + ": Пою '" + song + "' " + times + " раз");
    }
}

class BirdTest {
    public static void main(String[] args) {
        Bird bird = new Bird("Птица", "Неизвестная", 1.0);
        Eagle eagle = new Eagle("Гор", "Орел", 2.2, 320.0);
        Sparrow sparrow = new Sparrow("Чирик", "Воробей", 0.25, 60);

        bird.fly();
        bird.fly(100);
        bird.fly(2.5);

        eagle.fly();
        eagle.fly(50);
        eagle.fly(1.8);
        eagle.hunt();
        eagle.hunt("зайца");
        eagle.hunt("зайца", 500);

        sparrow.fly();
        sparrow.fly(5);
        sparrow.fly(0.5);
        sparrow.chirp();
        sparrow.chirp(5);
        sparrow.chirp("тень-тень", 3);

        Bird[] birds = {bird, eagle, sparrow};
        for (Bird b : birds) {
            System.out.println(b.name + " -> " + b.getFlightStyle());
        }
    }
}