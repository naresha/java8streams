package demo;

import java.io.Serializable;
import java.util.List;

public class Developer implements Serializable {
    private String name;
    private int age;
    private List<String> languages;

    public Developer(String name, int age, List<String> languages) {
        this.name = name;
        this.age = age;
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", languages=" + languages +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
