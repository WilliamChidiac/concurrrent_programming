package Modele;

import java.awt.Color;
import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

//This class is a model of a plant in the game

public class Plant {
    private static HashMap<Integer, Plant> plants = new HashMap<Integer, Plant>();
    private static int id_counter = 0;
    private int xp;
    private int money_collected;
    private int cost;
    private int growthTime;
    private int id;
    private int growthadvance;
    private boolean isGathered;
    private Point position;
    private Color color;

    public Plant(int xp, int cost, int growthTime, Point pos, int money_collected, Color color) {
        this.xp = xp;
        this.cost = cost;
        this.growthTime = growthTime;
        this.id = id_counter++;
        this.growthadvance = 0;
        this.position = pos;
        this.money_collected = money_collected;
        this.color = color;
        plants.put(id, this);
    }
    public static Plant getPlant(int id) {
        return plants.get(id);
    }
    public static Plant removePlant(int id) {
        Plant p = plants.remove(id);
        p.isGathered = true;
        return p;
    }
    public static Collection<Plant> getAllPlants() {
        return plants.values();
    }

    //Getters
    public int getXp() {
        return xp;
    }

    public int getCost() {
        return cost;
    }

    public int getMoney_collected() {
        return money_collected;
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

    public Color getColor() {
        return color;
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

    public Point gather() {
        this.isGathered = true;
        Point m_and_xp = new Point(money_collected, xp);
        return m_and_xp;
    }
}