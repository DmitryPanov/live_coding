package coding.streams.live.streams_7_7;

public class Cat extends Animal implements Pet {

    private String name;

    public Cat() {
        this("Garfield");
    }

    public Cat(String name) {
        super(4);
        this.name = name;
    }

    @Override
    public void doSomething() {
        System.out.println("Cat method!!!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

