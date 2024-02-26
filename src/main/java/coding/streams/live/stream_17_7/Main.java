package coding.streams.live.stream_17_7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static coding.streams.live.stream_17_7.Country.generateCities;
import static coding.streams.live.stream_17_7.Country.generateCountries;

public class Main {
    public static void main(String[] args) {
        List<City> cities = generateCities();
        List<Country> countries = generateCountries(cities);

//
//        getCountCapital(countries);
//        getCityByCode(cities);
//        getAvgArea(countries);
//        getMaxPopulation(countries);
//        getCitiStartWith(cities);
//        getCityByOneMillion(cities);

        //Подсчитать общее население всех стран на континенте "Азия"
        long sum = countries.stream()
                .map(Country::getPopulation)
                .mapToLong(Integer::intValue)
                .sum();
        System.out.println("sum = " + sum);

        Integer reduce = countries.stream()
                .map(Country::getPopulation)
                .reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);
        Optional<Integer> reduce1 = countries.stream()
                .map(Country::getPopulation)
                .reduce(Integer::sum);

        System.out.println("reduce1 = " + reduce1.get());


        // Выводим список городов
//        System.out.println("Список городов:");
//        for (City city : cities) {
//            System.out.println(city);
//        }
//
//        // Выводим список стран
//        System.out.println("\nСписок стран:");
//        for (Country country : countries) {
//            System.out.println(country);
//        }


    }

    private static void getCityByOneMillion(List<City> cities) {
        //Получить города с населением больше 1 миллиона человек.
        List<City> collect = cities.stream()
                .filter(city -> city.getPopulation() > 1_000_000)
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);
    }

    private static void getCitiStartWith(List<City> cities) {
        //Сгруппировать города по первой букве названия:
        Map<Character, List<City>> collect = cities.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(0)));
        System.out.println("collect = " + collect);
    }

    private static void getMaxPopulation(List<Country> countries) {
        //Получить страны с наибольшим населением для каждого континента:
        Map<String, Optional<Country>> countryMap = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent, Collectors.maxBy(Comparator.comparingInt(Country::getPopulation))));
        System.out.println("countryMap = " + countryMap);
    }

    private static void getAvgArea(List<Country> countries) {
        //Получить среднюю площадь стран для каждого континента:
        Map<String, Double> stringDoubleMap = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent, Collectors.averagingDouble(Country::getSurfaceArea)));
        System.out.println("stringDoubleMap = " + stringDoubleMap);
    }

    private static void getCityByCode(List<City> cities) {
        //Сгруппировать города по коду страны:
        Map<String, List<City>> collect1 = cities.stream()
                .collect(Collectors.groupingBy(City::getCountryCode));
        System.out.println("collect1 = " + collect1);
    }

    private static void getCountCapital(List<Country> countries) {
        //Получить количество столиц каждого континента:
        Map<String, Long> collect = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent, Collectors.counting()));
        System.out.println("collect = " + collect);
    }
}
