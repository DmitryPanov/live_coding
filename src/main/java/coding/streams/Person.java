package coding.streams;

import java.util.List;

public class Person {
    private String name;
    private List<String> children;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

    public Person(String name, List<String> children) {
        this.name = name;
        this.children = children;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }
}
