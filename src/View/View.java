package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Model.AllPlants;
import Model.Plant;

public class View extends JPanel{
    private AllPlants allPlants;
    public View(AllPlants allPlants) {
        super();
        this.setPreferredSize(new Dimension(500,500));
        this.allPlants = allPlants;
    }
    public void paint(Graphics g) {
        super.paint(g);
        for (Plant plant : allPlants.getPlants()) {
            g.fillOval(plant.getPositionx(), plant.getPositiony(), plant.getCWIDTH(), plant.getCHEIGHT());
            
            // Draw the background of the progression bar
            int maxBarWidth = 100; // Maximum width of the progression bar
            int barHeight = 10; // Height of the progression bar
            int barX = plant.getPositionx() - 25; // X position of the progression bar (same as the plant)
            int barY = plant.getPositiony() - 20; // Y position of the progression bar (above the plant)
            
            g.setColor(Color.GRAY); // Set the color of the background to gray
            g.fillRect(barX, barY, maxBarWidth, barHeight); // Draw the background of the progression bar
            
            // Draw the progress in the progression bar
            double growthRatio = (double) plant.getGrowthadvance() / plant.getGrowthTime(); // Ratio of current growth to maximum growth
            int progressWidth = (int) (maxBarWidth * growthRatio); // Width of the progress
            
            if (plant.getGrowthadvance() == plant.getGrowthTime()) {
                g.setColor(Color.RED); // Set the color of the progress to red if the growth is full
            } else {
                g.setColor(Color.GREEN); // Set the color of the progress to green if the growth is not full
            }
            
            g.fillRect(barX, barY, progressWidth, barHeight); // Draw the progress in the progression bar
        }
        g.dispose();
    }
}
