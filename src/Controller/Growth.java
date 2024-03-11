package Controller;

import Model.AllPlants;
import Model.Plant;

public class Growth extends Thread{
    private AllPlants allPlants;
    public Growth(AllPlants allPlants){ {
        this.allPlants = allPlants;
    }
    }
    @Override
    public void run() {
        while (true) {
            //for each plant, if it is not fully grown, it will grow
            for (Plant plant : allPlants.getPlants()) {
                if (plant.getGrowthadvance() < plant.getGrowthTime()) {
                    plant.grow();
                }
            }
            try {
                Growth.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

}
