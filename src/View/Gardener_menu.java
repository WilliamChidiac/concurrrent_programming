package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Score_and_prices;

public class Gardener_menu extends JPanel {

    //Attribute that contains the map of the game
    private Main_panel map;

    /**
     * Constructor that creates the gardener's menu with the buttons interactions
     * @param main the map of the game
     */
    public Gardener_menu(Main_panel main, Score_and_prices sp){
        super(new GridLayout(2,1));
        this.map = main;
        //Panel that contains the buttonsPanel for the gardener
        this.setBackground(Color.lightGray);
        //buttonsPanel.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/16));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //Definitions and Add buttons to the buttonsPanel
        JButton b1 = new JButton("Plant");
        b1.addActionListener(e ->
        {
            Point coordinate = Unite_controle_view.get_selected_unit().get_unite().get_current_location();
            map.add(new Plant_view(2, 3, 4,
            coordinate, sp ));
        }
        );
        JButton b2 = new JButton("Stay");
        b2.addActionListener(e -> map.stay());
        this.add(b1);
        this.add(b2);
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
