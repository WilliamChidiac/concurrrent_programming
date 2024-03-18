package View;

import javax.swing.*;
import java.awt.*;

public class Shop_menu extends JFrame{

    /**
     * Constructor that creates the shop's menu with the buttons without interaction
     * @return a shop's menu
     */
    public Shop_menu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        //Panel that contains the buttons without interaction
        JPanel buttonsShop = new JPanel(new GridLayout(3,2));
        buttonsShop.setBackground(Color.lightGray);
        buttonsShop.setPreferredSize(new Dimension(GameInterface.WIDTH/4, 50));
        buttonsShop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        buttonsShop.add(new JButton("Buy"));
        buttonsShop.add(new JButton("Sell"));

        TopLayer top = new TopLayer("Shop's actions :");
        top.add(buttonsShop, BorderLayout.SOUTH);
        this.add(top);
        this.pack();
    }

    /**
     * Main method to test the Shop_menu class
     * @param args
     */
    public static void main(String[] args) {
        //Test the Shop_menu class
        JFrame frame = new Shop_menu();
        frame.setVisible(true);
    }
}
