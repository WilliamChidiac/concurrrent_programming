package Modele;

import java.awt.Color;
import java.awt.Point;

public enum Plant_types {
    PLANT_TYPE1(5, 10, 4, 15, Color.PINK, "Rose", 
    "",
    "",
    "",
    ""),
    PLANT_TYPE2(7, 12, 6, 20, Color.MAGENTA, "Orchid", 
    "",
    "",
    "",
    ""),
    PLANT_TYPE3(10, 17, 9, 25, Color.RED, "Violette", 
    "",
    "",
    "",
    ""),
    PLANT_TYPE4(14, 22, 13, 30, Color.YELLOW, "Tulip", 
    "",
    "",
    "",
    "");

    public final int xp;
    public final int cost;
    public final int growthTime;
    public final int money_collected;
    public final Color color;
    public final String nom;
    public final String desc;
    public final String cons1;
    public final String cons2;
    public final String cons3;

    Plant_types(int xp, int cost, int growthTime, int money_collected, Color color, String nom, String desc, String c1, String c2, String c3) {
        this.xp = xp;
        this.cost = cost;
        this.growthTime = growthTime;
        this.money_collected = money_collected;
        this.color = color;
        this.nom = nom;
        this.desc = desc;
        this.cons1 = c1;
        this.cons2 = c2;
        this.cons3 = c3;
    }

    public Plant create_plant(Point pos) {
        return new Plant(this.xp, this.cost, this.growthTime, pos, this.money_collected, this.color);
    }
}