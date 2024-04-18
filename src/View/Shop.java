package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Plant_types;
import Modele.Score_and_prices;

public class Shop extends JFrame{

    /*
     * Create a shop with the 4 different types of plants
     */
    public Shop(Main_panel mp, Score_and_prices sp) {
        super("Shop");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        PlantShop plant1 = new PlantShop(Plant_types.PLANT_TYPE1, sp, mp);
        PlantShop plant2 = new PlantShop(Plant_types.PLANT_TYPE2, sp, mp);
        PlantShop plant3 = new PlantShop(Plant_types.PLANT_TYPE3, sp, mp);
        PlantShop plant4 = new PlantShop(Plant_types.PLANT_TYPE4, sp, mp);
        panel.add(plant1);
        panel.add(plant2);        
        panel.add(plant3);
        panel.add(plant4);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.add(panel);
        this.pack();
    }
}
