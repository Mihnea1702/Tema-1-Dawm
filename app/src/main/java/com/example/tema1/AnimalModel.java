package com.example.tema1;

public class AnimalModel {
    String name;
    String continent;

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

    public AnimalModel(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public String displayAnimal()
    {
        return name + " " + continent;
    }
}
