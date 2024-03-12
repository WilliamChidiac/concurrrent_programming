package View;

import javax.swing.*;
import java.awt.*;

public class Vue {
    //Constant WIDTH that definies the weight of the window, it has to be superior as the WIDTHMAP
    public static final int WIDTH = 1000;

    //Constant HEIGHT that definies the height of the window, it has to be superior as the HEIGHTMAP
    public static final int HEIGHT = 1000;

    //Attribute that contains the window
    private JFrame gameFrame;

    //Constructor that creates the window
    public Vue(){
        //Panel that contains the buttonsPanel
        JPanel buttonsPanel = new JPanel(new GridLayout(3,2));
        buttonsPanel.setBackground(Color.BLUE);

        // Definitions and Add buttons to the buttonsPanel
        JButton b1 = new JButton("Move");
        b1.addActionListener(e -> System.out.println("I move"));
        JButton b2 = new JButton("Plant");
        b2.addActionListener(e -> System.out.println("I plant"));
        JButton b3 = new JButton("Take");
        b3.addActionListener(e -> System.out.println("I take a plant"));
        JButton b4 = new JButton("Stay");
        b4.addActionListener(e -> System.out.println("Do nothing"));
        buttonsPanel.add(b1);
        buttonsPanel.add(b2);
        buttonsPanel.add(b3);
        buttonsPanel.add(b4);

        //Panel actions that contains the buttonsPanel
        JPanel actions = new JPanel(new BorderLayout());
        actions.setBackground(Color.darkGray);
        actions.add(buttonsPanel, BorderLayout.CENTER);
        JTextField top = new JTextField("\n  Actions");
        top.setEditable(false);
        top.setBackground(Color.LIGHT_GRAY);
        top.setBounds(0, 0, 0, 0);
        actions.add(top, BorderLayout.NORTH);

        //Panel that contains the map
        JPanel map = new JPanel();
        map.setBackground(Color.GREEN);

        //Fuse the panel of the map and the panel of the buttonsPanel in one main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        //Put the panel of the buttonsPanel on the right
        mainPanel.add(actions, BorderLayout.EAST);
        //Put the panel of the map on the left
        mainPanel.add(map, BorderLayout.CENTER);

        // Create the window, defines some parameters and add the mainPanel
        JFrame frame = new JFrame("Gardeners vs Rabbits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        //Defines the size of the window
        frame.setSize(WIDTH, HEIGHT);
        //Stock the frame in the attribute gameFrame
        this.gameFrame = frame;
    }


    //Method that allows to set the visibility of the window
    public void setVisible(boolean visible){
        this.gameFrame.setVisible(visible);
    }


    //Main function that test the window
    public static void main(String[] args) {
        Vue gameInterface = new Vue();
        gameInterface.setVisible(true);
    }
}