package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modele.Plant;

public class Plant_menu extends JPanel{

    //Attribute that contains the Plant
    private Plant plant;

    //Attribute that contains the status of the plant
    private JTextField str_plant_collectable;

    /**
     * Constructor that creates the plant's menu with the infos of the plant
     * @param p the plant selected
     * @return a plant's menu
     */
    public Plant_menu(Plant p) {
        //Initialization of the plant's menu
        super(new GridLayout(5, 1));
        this.plant = p;
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //Creatre the fields of the plant's menu
        JTextField str_plant_xp = new JTextField("Plant's xp : " + this.plant.getXp());
        str_plant_xp.setEditable(false);
        str_plant_xp.setBackground(Color.ORANGE);
        JTextField str_plant_cost = new JTextField("Plant's cost : " + this.plant.getCost());
        str_plant_cost.setEditable(false);
        str_plant_cost.setBackground(Color.ORANGE);
        JTextField str_plant_growthTime = new JTextField("Plant's growthTime : " + this.plant.getGrowthTime());
        str_plant_growthTime.setEditable(false);
        str_plant_growthTime.setBackground(Color.ORANGE);
        JTextField str_plant_pos = new JTextField("Plant's location : ("
                + (int) this.plant.getPosition().getX()
                + ", "
                + (int) this.plant.getPosition().getY() + ")");
        str_plant_pos.setEditable(false);
        str_plant_pos.setBackground(Color.ORANGE);
        JTextField str_plant_collectable = new JTextField("Plant's collectable : " + this.plant.isGrown());
        str_plant_collectable.setEditable(false);
        str_plant_collectable.setBackground(Color.ORANGE);
        this.str_plant_collectable = str_plant_collectable;

        //Add the fields to the plant's menu
        this.add(str_plant_xp);
        this.add(str_plant_cost);
        this.add(str_plant_growthTime);
        this.add(str_plant_pos);
        this.add(this.str_plant_collectable);
    }

    /**
     * Update the plant's collectable field in the menu when the plant is grown
     * @return void
     */
    public void update_collectable() {
        this.str_plant_collectable.setText("Plant's collectable : " + this.plant.isGrown());
    }

    /**
     * Main method to test the Plant_menu class
     * @param args
     */
    public static void main(String[] args) {
        //Test the Plant_menu class
        JFrame frame = new JFrame();
        //Main_panel map = new Main_panel(null);
        //Plant_view plant = new Plant_view(2, 3, 4, new Point(100, 100));

        /*(new Growth()).start();
        Refresh refresh = new Refresh(map);
        refresh.start();*/

        frame.add(new Plant_menu(new Plant(2, 3, 4, new Point(100, 100), 10)));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
