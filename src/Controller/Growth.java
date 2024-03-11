package Controller;


import Modele.Plant;

public class Growth extends Thread{
    public Growth() {
        super();
    }
    @Override
    public void run() {
        while (true) {
            //for each plant, if it is not fully grown, it will grow        
            for (Plant plant: Plant.getAllPlants()) {
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
