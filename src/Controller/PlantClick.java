package Controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.AllPlants;
import Model.Plant;

public class PlantClick extends MouseAdapter {
    private AllPlants allPlants;
    public PlantClick(AllPlants allPlants) {
        super();
        this.allPlants = allPlants;
    }
    @Override
    //if clicked in the area of the oval (position x y, widht = 50, height = 50) of the plant, the plant will be gathered only if it is fully grown
    public void mouseClicked(MouseEvent e) {
        for(Plant plant: allPlants.getPlants()){
            int centerX = plant.getPositionx() + plant.getCWIDTH() / 2;
            int centerY = plant.getPositiony() + plant.getCHEIGHT() / 2;
            int a = plant.getCWIDTH() / 2;
            int b = plant.getCHEIGHT() / 2;
        
            Point pointOnScreen = e.getComponent().getLocationOnScreen(); // Get the position of the component on the screen
            int screenX = pointOnScreen.x + e.getX(); // Get the x position of the mouse on the screen
            int screenY = pointOnScreen.y + e.getY(); // Get the y position of the mouse on the screen
        
            int dx = screenX - centerX; // Calculate the distance between the x position of the mouse and the center of the oval
            int dy = screenY - centerY; // Calculate the distance between the y position of the mouse and the center of the oval
        
            if ((dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1) { // If the mouse is inside the oval
                if (plant.getGrowthadvance() == plant.getGrowthTime()) {
                    int x = plant.gather();
                    System.out.println("Gathered " + x + " xp");
                    allPlants.addPlant(plant.createRandomPlant());
                    allPlants.removePlant(plant);
                }
            }
        }
    }


}
