import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Tom", 5, "Black", true));
        cats.add(new Cat("Jerry", 3, "White", false));
        cats.add(new Cat("Simba", 2, "Orange", true));
        cats.add(new Cat("Nala", 4, "Orange", false));
        cats.add(new Cat("Whiskers", 1, "Black", true));


        Map<String, Boolean> nameToIsHungryMap = cats.stream()
                .collect(Collectors.toMap(Cat::getName, Cat::isHungry));
        System.out.println("Map of name to hunger status: " + nameToIsHungryMap);


        Map<String, Long> colourToCountMap = cats.stream()
                .collect(Collectors.groupingBy(Cat::getColour, Collectors.counting()));
        System.out.println("Map of colour to count: " + colourToCountMap);

        
        Map<String, List<String>> colourToNamesMap = cats.stream()
                .collect(Collectors.groupingBy(Cat::getColour,
                        Collectors.mapping(Cat::getName, Collectors.toList())));
        System.out.println("Map of colour to names: " + colourToNamesMap);
    }
}

class Cat {
    private String name;
    private int age;
    private String colour;
    private boolean isHungry;

    public Cat(String name, int age, String colour, boolean isHungry) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.isHungry = isHungry;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColour() {
        return colour;
    }

    public boolean isHungry() {
        return isHungry;
    }
}
