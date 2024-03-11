package Modele;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

//This class is a model of a plant in the game

public class Plant {
    private static HashMap<Integer, Plant> plants = new HashMap<Integer, Plant>();
    private static int id_counter = 0;
    private int xp;
    private int cost;
    private int growthTime;
    private int id;
    private int growthadvance;
    private boolean isGathered;
    private Point position;

    public Plant(int xp, int cost, int growthTime, Point pos) {
        this.xp = xp;
        this.cost = cost;
        this.growthTime = growthTime;
        this.id = id_counter++;
        this.growthadvance = 0;
        this.position = pos;
        plants.put(id, this);
    }
    public static Plant getPlant(int id) {
        return plants.get(id);
    }
    public static Plant removePlant(int id) {
        return plants.remove(id);
    }
    public static Collection<Plant> getAllPlants() {
        return plants.values();
    }

    public int getXp() {
        return xp;
    }

    public int getCost() {
        return cost;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public int getId() {
        return id;
    }

    public int getGrowthadvance() {
        return growthadvance;
    }

    public Point getPosition() {
        return position;
    }

    public void grow() {
        if (growthadvance < growthTime) {
            growthadvance++;
        }
    }

    public boolean isGrown() {
        return growthadvance == growthTime;
    }

    public boolean isGathered() {
        return isGathered;
    }

    public int gather() {
        this.isGathered = true;
        return xp;
    }

    public static Plant createRandomPlant() {
        int xp = (int) (Math.random() * 100);
        int cost = (int) (Math.random() * 100);
        int growthTime = (int) (Math.random() * 20);
        Point position = new Point((int) (Math.random() * 500),
                                    (int) (Math.random() * 500));
        return new Plant(xp, cost, growthTime, position);
    }

}