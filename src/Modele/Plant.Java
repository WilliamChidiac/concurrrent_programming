public class Plant {
    private int xp;
    private int cost;
    private int growthTime;
    private int id;
    private int growthadvance;

    public Plant(int xp, int cost, int growthTime, int id) {
        this.xp = xp;
        this.cost = cost;
        this.growthTime = growthTime;
        this.id = id;
        this.growthadvance = 0;
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

    public void grow() {
        if (growthadvance < growthTime) {
            growthadvance++;
        }
    }

    public bool isGrown() {
        return growthadvance == growthTime;
    }

}