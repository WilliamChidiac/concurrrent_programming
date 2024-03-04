public class Plant {
    private int xp;
    private int cost;
    private int growthTime;
    private int id;
    private int growthadvance;
    private int positionx;
    private int positiony;

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

    public void grow() {
        if (growthadvance < growthTime) {
            growthadvance++;
        }
    }

    public bool isGrown() {
        return growthadvance == growthTime;
    }

}