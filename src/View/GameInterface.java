package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Growth;
import Modele.Score_and_prices;

public class GameInterface extends JFrame{
    //Constant WIDTH that definies the weight of the window, it has to be superior as the WIDTHMAP
    private final int WIDTH = Constant_view.WIDTH_WINDOW;

    //Constant HEIGHT that definies the height of the window, it has to be superior as the HEIGHTMAP
    private final int HEIGHT = Constant_view.HEIGHT_WINDOW;

    //Attribute that contains the panel of the info
    private JPanel infoPanel;
    

    //Attribute that contains the panel of the gardener
    private JPanel gardenerPanel;
    //Attribute that contains the panel of the shop
    private JPanel shopPanel;
    
    //Attribute that contains the panel of the rabbit
    private JPanel rabbitPanel;

    private JTextField score = new JTextField("Score : 0");

    //Constructor that creates the window
    public GameInterface(String game_title, Score_and_prices sp){
        super(game_title);
        //Panel that contains the map
        Main_panel map = new Main_panel();
        map.setBackground(Color.GREEN);

        sp.setGameInterface(this);

        
        Unite_controle_view u1 = new Unite_controle_view(new Point(50, 50), Color.RED);
        Unite_controle_view u2 = new Unite_controle_view(new Point(200, 200), Color.BLUE);
        Plant_view pv1 = new Plant_view(2, 3, 4, new Point(100, 100), sp);
        Plant_view pv2 = new Plant_view(2, 3, 4, new Point(100, 200), sp);
        map.add_unit(u2);
        map.add_unit(u1);
        map.add_plant(pv1);
        map.add_plant(pv2);

        (new Growth()).start();


        //Panel that contains the buttonsPanel for the gardener
        JPanel buttonsPanel = new JPanel(new GridLayout(10,2));
        buttonsPanel.setBackground(Color.lightGray);
        buttonsPanel.setPreferredSize(new Dimension(WIDTH/4, 50));
        buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //Definitions and Add buttons to the buttonsPanel
        JButton b1 = new JButton("Market");
        b1.addActionListener(e -> System.out.println("go to the market"));
        JButton b2 = new JButton("Plant");
        b2.addActionListener(e -> map.add(new Plant_view(2, 3, 4, (Point) Unite_controle_view.get_selected_unit().get_unite().get_current_location().clone(), sp )));
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
        //this.gardenerPanel = new Gardener_menu(map);

        //Fuse the panel of the map and the panel of the buttonsPanel in one main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        //Put the panel of the buttonsPanel on the right
        //mainPanel.add(this.gardenerPanel, BorderLayout.EAST);
        //Put the panel of the map on the left
        mainPanel.add(map, BorderLayout.CENTER);

        JPanel info = new JPanel(new BorderLayout());
        this.infoPanel = info;
        mainPanel.add(infoPanel, BorderLayout.EAST);
        score.setEditable(false);
        infoPanel.add(score, BorderLayout.NORTH);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(mainPanel);
        this.pack();
        //Defines the size of the window
        this.setSize(WIDTH, HEIGHT);

    }
    
    public void updateScore(int score) {
        this.score.setText("Score : " + score);
    }


    //Method that allows to add a panel to the gameFrame at the right of the window
    public void addGardenerPanel(){
        this.infoPanel.add(this.gardenerPanel, BorderLayout.EAST);
        this.repaint();
    }


    //Method that remove the current buttons panel of the mainPanel
    public void removeGardenerPanel(){
        this.infoPanel.remove(this.gardenerPanel);
        this.repaint();
    }
}
