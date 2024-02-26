package coding.streams.live.streams_7_7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppStreams {
    public static void main(String[] args) {
        List<Animal> animals = List.of(new Spider(), new Cat(), new Fish("Free Willy"),
                new Cat("Tekir"), new Fish("Jaws"), new Spider());

//        isPets(animals);
//        isWildAnimal(animals);
//        maxLegs(animals);
//        sumLegs(animals);
//        collectLegsAnimals(animals);
//        getClass(animals);
//        countClassAnimals(animals);
//        reverseMaps();

    }

    private static void reverseMaps() {
        List<Integer> integers = List.of(1, 6, 3, 3, 3, 2, 1, 8, 8, 9, 3, 1, 1);

        Map<Integer, Long> collect = integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("collect = " + collect);

        Map<Integer, Long> collectReverse = integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), () -> new TreeMap<Integer, Long>(Comparator.reverseOrder()), Collectors.counting()));

        System.out.println("collectReverse = " + collectReverse);
    }

    private static void countClassAnimals(List<Animal> animals) {
        long countClass = animals.stream()
                .map(Animal::getClass)
                .distinct()
                .count();
        System.out.println("countClass = " + countClass);
    }

    private static void getClass(List<Animal> animals) {
        Map<Class<?>, Long> collect = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClass, Collectors.counting()));
        System.out.println("collect = " + collect);
    }

    private static void collectLegsAnimals(List<Animal> animals) {
        Map<Integer, Long> collect = animals.stream()
                .collect(Collectors.groupingBy(Animal::getLegs, Collectors.counting()));
        System.out.println("collect = " + collect);

        Map<Integer, List<Animal>> collect1 = animals.stream()
                .collect(Collectors.groupingBy(Animal::getLegs, Collectors.toList()));
        System.out.println("collect1 = " + collect1);

        Map<Integer, List<Animal>> collect2 = animals.stream()
                .collect(Collectors.groupingBy(Animal::getLegs));
        System.out.println("collect2 = " + collect2);
    }

    private static void sumLegs(List<Animal> animals) {
        int sumLegs = animals.stream()
                .mapToInt(Animal::getLegs)
                .sum();

        System.out.println("sumLegs = " + sumLegs);
    }

    private static void maxLegs(List<Animal> animals) {
        Integer max = animals.stream()
                .max(Comparator.comparingInt(Animal::getLegs))
                .map(Animal::getLegs)
                .get();

        System.out.println("max.get() = " + max);
    }

    private static void isWildAnimal(List<Animal> animals) {
        List<Animal> collectWildAnimal = animals.stream()
                .filter(elem -> !(elem instanceof Pet))
                .collect(Collectors.toList());

        System.out.println("collectWildAnimal = " + collectWildAnimal);
    }

    private static void isPets(List<Animal> animals) {
        List<Animal> collectPets = animals.stream()
                .filter(elem -> elem instanceof Pet)
                .collect(Collectors.toList());

        System.out.println("collectPets = " + collectPets);
    }
}
