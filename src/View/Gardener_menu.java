package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Modele.Score_and_prices;

public class Gardener_menu extends TopLayer {

    //Attribute that contains the map of the game
    private Main_panel map;

    /**
     * Constructor that creates the gardener's menu with the buttons interactions
     * @param main the map of the game
     * @return a gardener's menu
     */
    public Gardener_menu(Main_panel main, Score_and_prices sp){
        super("Gardener's actions :");
        this.map = main;
        //Panel that contains the buttonsPanel for the gardener
        JPanel buttonsPanel = new JPanel(new GridLayout(10,2));
        buttonsPanel.setBackground(Color.lightGray);
        //buttonsPanel.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/16));
        buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //Definitions and Add buttons to the buttonsPanel
        JButton b1 = new JButton("Market");
        b1.addActionListener(e -> System.out.println("go to the market"));
        JButton b2 = new JButton("Plant");
        b2.addActionListener(e ->
        {
            Point coordinate = Unite_controle_view.get_selected_unit().get_unite().get_current_location();
            map.add(new Plant_view(2, 3, 4,
            coordinate, sp ));
        }
        );
        JButton b3 = new JButton("Take");
        b3.addActionListener(e -> System.out.println("I take a plant"));
        JButton b4 = new JButton("Stay");
        b4.addActionListener(e -> map.stay());
        //buttonsPanel.add(b1);
        buttonsPanel.add(b2);
        buttonsPanel.add(b3);
        buttonsPanel.add(b4);
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    /**
     * Main method to test the Gardener_menu class
     * @param args
     */
    public static void main(String[] args) {
        //Test the Gardener_menu class
        JFrame frame = new JFrame();
        Score_and_prices sp = new Score_and_prices();
        frame.add(new Gardener_menu(null, sp));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
