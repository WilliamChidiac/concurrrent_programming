package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Modele.Plant;
import View.Main_panel;
import View.Plant_view;

public class PlantClick extends MouseAdapter {
    private Plant_view plant_view;
    public PlantClick(Plant_view pv) {
        super();
        this.plant_view = pv;
    }
    @Override
    //if clicked in the area of the oval (position x y, widht = 50, height = 50) of the plant, the plant will be gathered only if it is fully grown
    public void mouseClicked(MouseEvent e) {
        Plant plant = this.plant_view.getPlant();
        if (plant.getGrowthadvance() == plant.getGrowthTime() && isCollectable()) {
            int x = plant.gather();
            System.out.println("Gathered " + x + " xp");
            JPanel parent = (JPanel) this.plant_view.getParent();
            parent.remove(this.plant_view);
            parent.revalidate();
            parent.repaint();
            Plant.removePlant(plant.getId());
        }
    }

    //Method which return true if plant_view parent attribute unit_selected is not null
    public Boolean isCollectable(){
        return ((Main_panel) plant_view.getParent()).get_unit_selected() != null;
    }
}
