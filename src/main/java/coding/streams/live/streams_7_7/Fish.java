package coding.streams.live.streams_7_7;

public class Fish extends Animal implements Pet {
    private String name;

    public Fish(String name) {
        super(0);
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play() {
        System.out.printf("%s is playing now...%n", name);
    }

    @Override
    public void eat() {
        System.out.printf("%s is eating now...%n", name);
    }

    @Override
    public void walk() {
        System.out.printf("%s is swimming now...%n", name);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                '}';
    }
}

