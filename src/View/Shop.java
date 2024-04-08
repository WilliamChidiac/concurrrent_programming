package View;

import Modele.Score_and_prices;

import javax.swing.*;
import java.awt.*;

public class Shop extends JFrame{

    //Attribute that contains the map of the game
    private Main_panel map;

    //Attribute that contains the score and prices of the game
    private Score_and_prices sp;

    /**
     * Constructor that creates the shop window with the plant buttons
     * @param m the map of the game, sp the score and prices of the game
     */
    public Shop(Main_panel m, Score_and_prices sp){
        super("Shop");
        this.map = m;
        this.sp = sp;

        //Panel that contains the buttons without interaction
        JPanel buttonsShop = new JPanel(new GridLayout(2,2));
        buttonsShop.setBackground(Color.lightGray);
        buttonsShop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        //Add buttons to the panel for the shop, each buttons plant a plant when clicked
        JButton plant1 = new JButton("Plant 1");
        plant1.addActionListener(e -> {
            this.addPlant(this.map, this.sp, 2, 3, 4);
        });
        buttonsShop.add(plant1);

        JButton plant2 = new JButton("Plant 2");
        plant2.addActionListener(e->{
            this.addPlant(this.map, this.sp, 200, 3, 0);
        });
        buttonsShop.add(plant2);

        buttonsShop.add(new JButton("Plant 3"));

        this.add(buttonsShop);
        this.setSize(800, 600);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Default constructor
     */
    public Shop() {
        this(null, null);
    }

    /**
     * Method that adds a plant to the map
     * @param map the map of the game, sp the score and prices of the game,
     *            xp the experience of the plant, cost the cost of the plant,
     *            growth_time the time of growth of the plant
     */
    public void addPlant(Main_panel map, Score_and_prices sp, int xp, int cost, int growth_time){
        Point coordinate = (Point) Unite_controle_view.get_selected_unit().get_unite().get_current_location().clone();
        Plant_view pv = new Plant_view(xp, cost, growth_time, coordinate, sp);
        map.add_plant(pv);
    }

    /**
     * Main method to test the Shop_menu class
     * @param args
     */
    public static void main(String[] args) {
        //Test the visual of Shop_menu class
        JFrame frame = new Shop();
        frame.setVisible(true);
    }
}
