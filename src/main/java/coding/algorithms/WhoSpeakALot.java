package coding.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WhoSpeakALot {
    public static void main(String[] args) {
        List<String> stringList = List.of("jhone: a a a a a a a a a a a a a ",
                "endy: hi all",
                "sam: hello all",
                "fry: good day all fallows",
                "sam: how are you all");

        findAMostTalkingAuthors(stringList, 1);
        System.out.println("stringList = " + findAMostTalkingAuthorsStreamToMap(stringList, 2));
    }

    public static List<String> findAMostTalkingAuthorsStreamToMap(List<String> records, int numToView) {
            return records.stream()
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(e -> e[0], e -> e[1]
                                .trim()
                                .split(" ")
                                .length,
                        (value1, value2) -> {
                            System.out.println("Когда найден ключ складывать значения полученые из ключа!");
                            return value1 + value2;
                        })).entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(numToView)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> findAMostTalkingAuthors(List<String> records, int numToView) {
        Map<String, Integer> lengthPeople = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            String[] strings = records.get(i).split(":");
            String author = strings[0];
            Integer wordsLength = strings[1].trim().split(" ").length;

            if (lengthPeople.containsKey(author)) {
                lengthPeople.put(author, lengthPeople.get(author) + wordsLength);
            } else {
                lengthPeople.put(author, wordsLength);
            }
        }

        if (numToView >= lengthPeople.size()) {
            return new ArrayList<>(lengthPeople.keySet());
        } else {
            List<String> collect = lengthPeople.entrySet()
                    .stream()
                    .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                    .map(Map.Entry::getKey)
                    .limit(numToView)
                    .collect(Collectors.toList());
            System.out.println("collect = " + collect);
            return collect;
        }
    }
}
