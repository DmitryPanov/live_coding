package coding.streams.live.stream_17_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Country {

    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
    private List<City> cities;

    {
        cities = new ArrayList<>();
    }

    public Country() {
    }

    public Country(String code, String name, String continent, double surfaceArea, int population, double gnp, int capital, List<City> cities) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
        this.cities = cities;
    }

    public static List<City> generateCities() {
        List<City> cities = new ArrayList<>();
        // Создаем 20 объектов City и добавляем их в список
        for (int i = 1; i <= 20; i++) {
            City city = new City(i, "City" + i, i * 100_000, "C" + i);
            cities.add(city);
        }
        return cities;
    }

    public static List<Country> generateCountries(List<City> cities) {
        List<Country> countries = new ArrayList<>();
        Random random = new Random();
        // Создаем 10 объектов Country и добавляем их в список
        for (int i = 1; i <= 10; i++) {
            List<City> countryCities = new ArrayList<>();
            // Добавляем n случайных города из списка cities в список городов страны
            for (int j = 0; j < random.nextInt(10); j++) {
                countryCities.add(cities.get(j));
            }

            Country country = new Country("Code" + i, "Country" + i, "Continent" + i, i * 1000, i * 1_000_000, i * 10_000, i, countryCities);
            countries.add(country);
        }
        return countries;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getGnp() {
        return gnp;
    }

    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", population=" + population +
                ", gnp=" + gnp +
                ", capital=" + capital +
                ", cities=" + cities +
                '}';
    }
}