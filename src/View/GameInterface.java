package View;

import Controller.Growth;

import javax.swing.*;
import java.awt.*;

public class GameInterface {
    //Constant WIDTH that definies the weight of the window, it has to be superior as the WIDTHMAP
    public static final int WIDTH = 1000;

    //Constant HEIGHT that definies the height of the window, it has to be superior as the HEIGHTMAP
    public static final int HEIGHT = 1000;

    //Attribute that contains the window
    private JFrame gameFrame;

    //Attribute that contains the panel of the window
    private JPanel mainPanel;

    //Attribute that contains the panel of the gardener
    private JPanel gardenerPanel;

    //Attribute that contains the panel of the shop
    private JPanel shopPanel;

    //Attribute that contains the panel of the rabbit
    private JPanel rabbitPanel;


    //Constructor that creates the window
    public GameInterface(){
        //Panel that contains the buttons without interaction
        JPanel buttonsShop = new JPanel(new GridLayout(3,2));
        buttonsShop.setBackground(Color.lightGray);
        buttonsShop.setPreferredSize(new Dimension(WIDTH/4, 50));
        buttonsShop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //Top layer for the buttonsShop
        JPanel actionShop = new JPanel(new BorderLayout());
        actionShop.setBackground(Color.darkGray);
        actionShop.add(buttonsShop, BorderLayout.CENTER);
        JTextField topShop = new JTextField(" Shop :");
        topShop.setEditable(false);
        topShop.setHorizontalAlignment(JTextField.CENTER);
        topShop.setBackground(Color.LIGHT_GRAY);
        topShop.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/16));
        actionShop.add(topShop, BorderLayout.NORTH);
        this.shopPanel = actionShop;


        //Panel that contains the map
        Main_panel map = new Main_panel(this);
        map.setBackground(Color.GREEN);
        
        Unite_controle_view u1 = new Unite_controle_view(new Point(50, 50), Color.RED);
        Unite_controle_view u2 = new Unite_controle_view(new Point(200, 200), Color.BLUE);
        Plant_view pv1 = new Plant_view(2, 3, 4, new Point(100, 100));
        Plant_view pv2 = new Plant_view(2, 3, 4, new Point(100, 200));
        map.add_unit(u2);
        map.add_unit(u1);
        map.add_plant(pv1);
        map.add_plant(pv2);

        (new Growth()).start();
        Refresh refresh = new Refresh(map);
        refresh.start();

        //Panel that contains the buttonsPanel for the gardener
        JPanel buttonsPanel = new JPanel(new GridLayout(10,2));
        buttonsPanel.setBackground(Color.lightGray);
        buttonsPanel.setPreferredSize(new Dimension(WIDTH/4, 50));
        buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //Definitions and Add buttons to the buttonsPanel
        JButton b1 = new JButton("Market");
        b1.addActionListener(e -> System.out.println("go to the market"));
        JButton b2 = new JButton("Plant");
        b2.addActionListener(e -> map.add(new Plant_view(2, 3, 4,
                new Point((int) ((Unite_controle_view) map.get_unit_selected()).get_unite().get_current_location().getX(),
                        (int) ((Unite_controle_view) map.get_unit_selected()).get_unite().get_current_location().getY()) )));
        JButton b3 = new JButton("Take");
        b3.addActionListener(e -> System.out.println("I take a plant"));
        JButton b4 = new JButton("Stay");
        b4.addActionListener(e -> map.stay());
        //buttonsPanel.add(b1);
        buttonsPanel.add(b2);
        buttonsPanel.add(b3);
        buttonsPanel.add(b4);

        //Panel actions that contains the buttonsPanel
        JPanel actions = new JPanel(new BorderLayout());
        actions.setBackground(Color.darkGray);
        actions.add(buttonsPanel, BorderLayout.CENTER);
        String gardenerName = "Gardener's";
        JTextField top = new JTextField(gardenerName+ " actions :");
        top.setEditable(false);
        top.setHorizontalAlignment(JTextField.CENTER);
        top.setBackground(Color.LIGHT_GRAY);
        top.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/16));
        actions.add(top, BorderLayout.NORTH);
        this.gardenerPanel = actions;

        //Fuse the panel of the map and the panel of the buttonsPanel in one main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        //Put the panel of the buttonsPanel on the right
        //mainPanel.add(this.gardenerPanel, BorderLayout.EAST);
        //Put the panel of the map on the left
        mainPanel.add(map, BorderLayout.CENTER);
        this.mainPanel = mainPanel;

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


    //Method that allows to add a panel to the gameFrame at the right of the window
    public void addGardenerPanel(){
        this.mainPanel.add(this.gardenerPanel, BorderLayout.EAST);
        this.gameFrame.repaint();
    }


    //Method that remove the current buttons panel of the mainPanel
    public void removeGardenerPanel(){
        this.mainPanel.remove(this.gardenerPanel);
        this.gameFrame.repaint();
    }


    //Main function that test the window
    public static void main(String[] args) {
        GameInterface gameInterface = new GameInterface();
        gameInterface.setVisible(true);
    }
}
