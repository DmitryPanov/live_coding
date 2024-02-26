package coding.streams.live.streams_7_7;

public abstract class Animal {
    private final int legs;

    public Animal(int legs) {
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    public void walk() {
        System.out.println(
                String.format("Animal with %d legs is walking now...", legs)
        );
    }

    public void doSomething(){
        System.out.println("Animal method!!!");
    }

    public abstract void eat(); // abstract method

}