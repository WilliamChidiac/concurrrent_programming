package Modele;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

//This class is a model of a plant in the game

public class Plant {
    private static HashMap<Integer, Plant> plants = new HashMap<Integer, Plant>();
    private static int id_counter = 0;
    private int xp;
    private int money_collected;
   private EspecePlante esplante;
    private int id;
    private int growthadvance;
    private boolean isGathered;
    private Point position;

    public Plant(int xp, EspecePlante plante, Point pos, int money_collected) {
        this.xp = xp;
        this.esplante = new EspecePlante();
        this.id = id_counter++;
        this.growthadvance = 0;
        this.position = pos;
        this.money_collected = money_collected;
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

    public int getXp() {
        return xp;
    }

    public int getCost() {
        return this.esplante.getPrix();
    }

    public int getGrowthTime() {
        return esplante.getTimeGrowth();
    }
    public EspecePlante getEsplante(){
        return this.esplante;
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
        if (growthadvance < esplante.getTimeGrowth()) {
            growthadvance++;
        }
    }

    public boolean isGrown() {
        return growthadvance == esplante.getTimeGrowth();
    }

    public boolean isGathered() {
        return isGathered;
    }

    public Point gather() {
        this.isGathered = true;
        Point m_and_xp = new Point(money_collected, xp);
        return m_and_xp;
    }

    public static Plant createRandomPlant() {
        int xp = (int) (Math.random() * 100);
        int cost = (int) (Math.random() * 100);
        int growthTime = (int) (Math.random() * 20);
        Point position = new Point((int) (Math.random() * 500),
                                    (int) (Math.random() * 500));
        int money_collected = (int) (Math.random() * 100);
        return new Plant(xp, new EspecePlante(), position, money_collected);
    }

}