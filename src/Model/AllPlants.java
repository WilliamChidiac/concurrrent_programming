package Model;

import java.util.ArrayList;

//This class is a collection of all the plants in the game

public class AllPlants {
    private ArrayList<Plant> plants;
    public AllPlants() {
        this.plants = new ArrayList<Plant>();
    }
    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }
    public void removePlant(Plant plant) {
        this.plants.remove(plant);
    }
    public void printPlants() {
        for (Plant plant : plants) {
            System.out.println(plant);
        }
    }
    public ArrayList<Plant> getPlants() {
        return plants;
    }
}
