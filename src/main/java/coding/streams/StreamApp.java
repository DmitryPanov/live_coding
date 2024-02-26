package coding.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamApp {
    public static void main(String[] args) {
        List<String> stringList = List.of("first second trd", "SUPER Puper", "DD", "TTTT", "YYY");

        String collect = String.valueOf(stringList.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .max(Comparator.comparingInt(String::length)));

        System.out.println("collect = " + collect);
    }
}
