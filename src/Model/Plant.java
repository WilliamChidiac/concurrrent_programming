package Model;

//This class is a model of a plant in the game

public class Plant {
    private int xp;
    private int cost;
    private int growthTime;
    private int id;
    private int growthadvance;
    private int positionx;
    private int positiony;
    private boolean isGathered;
    private int CWIDTH = 50;
    private int CHEIGHT = 50;

    public Plant(int xp, int cost, int growthTime, int id, int positionx, int positiony) {
        this.xp = xp;
        this.cost = cost;
        this.growthTime = growthTime;
        this.id = id;
        this.growthadvance = 0;
        this.positionx = positionx;
        this.positiony = positiony;
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

    public int getPositionx() {
        return positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public int getCWIDTH() {
        return CWIDTH;
    }

    public int getCHEIGHT() {
        return CHEIGHT;
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

    public Plant createRandomPlant() {
        int xp = (int) (Math.random() * 100);
        int cost = (int) (Math.random() * 100);
        int growthTime = (int) (Math.random() * 20);
        int id = (int) (Math.random() * 100);
        int positionx = (int) (Math.random() * 500);
        int positiony = (int) (Math.random() * 500);
        return new Plant(xp, cost, growthTime, id, positionx, positiony);
    }

}