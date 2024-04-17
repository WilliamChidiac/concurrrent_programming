package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import Controller.PlantClick;
import Modele.Plant;
import Modele.Score_and_prices;

public class Plant_view extends JPanel{
    private int plant_id;
    public Plant_view(Plant p, Score_and_prices sp) {
        super();
        Point pos = p.getPosition();
        this.plant_id = p.getId();
        this.addMouseListener(new PlantClick(this, sp));
        this.setBounds(pos.x, pos.y, Constant_view.PLANT_BW, (Constant_view.PLANT_BH+Constant_view.PLANT_GAP+Constant_view.PLANT_RADIUS*2));
        this.setOpaque(false);
        
    }

    public Plant getPlant() {
        return Plant.getPlant(plant_id);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Plant plant = this.getPlant();
        Point pos = plant.getPosition();
        this.setLocation(pos.x - Constant_view.PLANT_RADIUS, 
                        pos.y - Constant_view.PLANT_RADIUS - Constant_view.PLANT_GAP - Constant_view.PLANT_BH);
        this.revalidate();
        g.setColor(plant.getColor());
        g.fillOval(0,
        Constant_view.PLANT_RADIUS - Constant_view.PLANT_GAP,
        Constant_view.PLANT_RADIUS*2, 
        Constant_view.PLANT_RADIUS*2);
        
        // Draw the background of the progression bar
        int maxBarWidth = Constant_view.PLANT_BW; // Maximum width of the progression bar
        int barHeight = Constant_view.PLANT_BH; // Height of the progression bar
        
        
        // Draw the progress in the progression bar
        double growthRatio = (double) plant.getGrowthadvance() / plant.getGrowthTime(); // Ratio of current growth to maximum growth
        int progressWidth = (int) (maxBarWidth * growthRatio); // Width of the progress
        
        if (plant.getGrowthadvance() != plant.getGrowthTime()) {
            g.setColor(Color.GRAY); // Set the color of the background to gray
            g.fillRect(0, 0, maxBarWidth, barHeight); // Draw the background of the progression bar
            g.setColor(Color.RED); // Set the color of the progress to red if the growth is not full
            g.fillRect(0,0, progressWidth, barHeight); // Draw the progress in the progression bar
        }
        
        g.dispose();
    }
}
