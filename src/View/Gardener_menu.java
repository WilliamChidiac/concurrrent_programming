package View;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Score_and_prices;

public class Gardener_menu extends JPanel {

    //Attribute that contains the map of the game
    private Main_panel map;

    //Attribute that contains the shop
    private Shop shop;


    /**
     * Constructor that creates the gardener's menu with the buttons interactions
     * @param main the map of the game
     */
    public Gardener_menu(Main_panel main, Score_and_prices sp){
        //Initialization of the gardener's menu
        super(new BorderLayout());
        this.map = main;
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //Initialization of the JFrame shop
        this.shop = new Shop(map, sp);
        this.hideShop();

        //Panel that contains the buttonsPanel for the gardener
        JPanel buttonsPanel = new JPanel(new GridLayout(2,1));
        buttonsPanel.setBackground(Color.lightGray);

        //Definitions and Add buttons to the buttonsPanel
        JButton b1 = new JButton("Plant");
        b1.addActionListener(e ->
        {
            //If the shop is not visible, show it
            if(!this.shop.isVisible()) this.showShop();
            //If the shop is visible, hide it
            else this.hideShop();
        }
        );
        JButton b2 = new JButton("Stay");
        b2.addActionListener(e -> map.stay());
        buttonsPanel.add(b1);
        buttonsPanel.add(b2);

        //Add the buttonsPanel to the gardener's menu
        this.add(buttonsPanel, BorderLayout.NORTH);
    }

    //Hide the shop JFrame
    public void hideShop() {
        this.shop.setVisible(false);
    }

    //Show the shop JFrame
    public void showShop() {
        this.shop.setVisible(true);
    }

    //Dispose the shop JFrame
    public void disposeShop() {
        this.shop.dispose();
    }

    /**
     * Main method to test the Gardener_menu class
     */
    public static void main(String[] args) {
        //Test the Gardener_menu class
        JFrame frame = new JFrame();
        Score_and_prices sp = new Score_and_prices();

        frame.add(new Gardener_menu(null, sp));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
