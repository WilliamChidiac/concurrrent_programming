package Modele;

import java.awt.Color;
import java.awt.Point;

public enum Plant_types {
    PLANT_TYPE1(5, 10, 4, 15, Color.PINK),
    PLANT_TYPE2(7, 12, 6, 20, Color.MAGENTA),
    PLANT_TYPE3(10, 17, 9, 25, Color.RED),
    PLANT_TYPE4(14, 22, 13, 30, Color.YELLOW),;

    private final int xp;
    private final int cost;
    private final int growthTime;
    private final int money_collected;
    private final Color color;

    Plant_types(int xp, int cost, int growthTime, int money_collected, Color color) {
        this.xp = xp;
        this.cost = cost;
        this.growthTime = growthTime;
        this.money_collected = money_collected;
        this.color = color;
        
    }

    public Plant create_plant(Point pos) {
        return new Plant(this.xp, this.cost, this.growthTime, pos, this.money_collected, this.color);
    }
}