package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Round_initializer;

import javax.swing.JLabel;

import Modele.Plant;
import Modele.Score_and_prices;

public class GameInterface extends JFrame{

    private JPanel gameState;
    private CardLayout states;
    private Main_panel main_panel;
    private Score_and_prices sc;

    //Attribute that contains the principal panel of the game
    private JPanel windowPanel;

    private Round_initializer ri = null;

    //Attribute that contains the panel of the gardener
    private Gardener_menu gardenerPanel;

    //Attribute that contains the panel of the plant
    private Plant_menu plantPanel;

    //Attribute that shows if the game is ended
    private boolean ended = false;

    //Constructor that creates the window
    public GameInterface(String game_title, Score_and_prices sp){
        super(game_title);

        this.sc = sp;
        //Panel that contains the map
        Main_panel map = new Main_panel();
        this.main_panel = map;
        map.setBackground(Color.GREEN);
        sp.setGameInterface(this);

        //Panel that contains the menu of the gardener
        this.gardenerPanel = new Gardener_menu(map, sp);

        //Fuse the panel of the map and the panel of the buttonsPanel in one main panel
        this.windowPanel = new JPanel(new BorderLayout());
        windowPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        //Add the map panel to the mainPanel
        windowPanel.add(map, BorderLayout.CENTER);
        //Add the menu panel to the mainPanel
        windowPanel.add(new TopLayer("Menu"), BorderLayout.EAST);

        //Set the parameters of the window and add the windowPanel to the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        states = new CardLayout();
        gameState = new JPanel(states);
        JPanel menu = new JPanel();
        menu.add(new JLabel("Menu"));
        JButton play = new JButton("Play");
        play.addActionListener(e -> {
            this.ri.start();
            states.show(gameState, "game");
            
        });
        menu.add(play);
        menu.setPreferredSize(new Dimension(800, 600));
        menu.setVisible(true);

        JPanel win = new JPanel();
        win.add(new JLabel("You win !"));
        JPanel loose = new JPanel();
        loose.add(new JLabel("You lose !"));
        win.setPreferredSize(new Dimension(800, 600));
        loose.setPreferredSize(new Dimension(800, 600));
        win.setVisible(true);
        loose.setVisible(true);
        gameState.add(menu, "menu");
        gameState.add(windowPanel, "game");
        gameState.add(win, "win");
        gameState.add(loose, "loose");
        this.switch_window("menu");
        gameState.setVisible(true);


        this.add(gameState);
        this.pack();
    }
    public void switch_window(String state){
        states.show(gameState, state);
    }

    //getter for mainpanel
    public Main_panel getMain_panel(){
        return this.main_panel;
    }
    //getter for score
    public Score_and_prices getScore(){
        return this.sc;
    }

    //setter for round init
    public void round_init(Round_initializer rdi){
        this.ri = rdi;
    }

    //Method that adds a plant
    public void addPlant(Plant p){
        Plant_view pv = new Plant_view(p, this.sc);
        this.main_panel.add_plant(pv);
    }

    //Method that allows to update the time in the top layer
    public void updateTime(int time) {
        //Get the top layer
        TopLayer top = (TopLayer) this.windowPanel.getComponent(1);

        //Update the text of the second JTextField with the new time
        top.updateTime(time);
    }

    //Method that allows to update the score in the top layer
    public void updateScore(int score) {
        //Get the top layer
        TopLayer top = (TopLayer) this.windowPanel.getComponent(1);

        //Update the text of the first JTextField with the new score
        top.updateScore(score);
    }

    //Method that allows to update the money in the top layer
    public void updateMoney(int money) {
        //Get the top layer
        TopLayer top = (TopLayer) this.windowPanel.getComponent(1);

        //Update the text of the second JTextField with the new money
        top.updateMoney(money);
    }

    //Method that allows to remove the last panel added and add the gardenerMenu to the topLayer
    public void addGardenerMenu(){
        //Remove the last panel added to the topLayer
        this.removeLastPanel();

        //Get the TopLayer of the windowPanel
        TopLayer top = (TopLayer) this.windowPanel.getComponent(1);

        //Add the gardenerMenu to the topLayer
        top.add(this.gardenerPanel, BorderLayout.CENTER);

        //Set the title of the topLayer to Gardener
        top.setTitle("Gardener's " + Unite_controle_view.get_selected_unit().get_unite().get_id() +" actions :");
    }

    //Method that allows to remove the last panel added and add the plantMenu to the topLayer
    public void addPlantMenu(Plant p){
        //Remove the last panel added to the topLayer
        this.removeLastPanel();
        //Get the top layer and initialize the plant menu
        TopLayer top = (TopLayer) this.windowPanel.getComponent(1);
        this.plantPanel = new Plant_menu(p);

        //Add the plantMenu to the topLayer
        top.add(this.plantPanel, BorderLayout.CENTER);

        //Set the title of the topLayer to Plant
        top.setTitle("Plant's " + p.getId() +" informations :");
    }

    //Method that remove the last panel added to the topLayer if there is one
    public void removeLastPanel(){
        //Get the top layer
        TopLayer top = (TopLayer) this.windowPanel.getComponent(1);

        //Check if there is a panel to remove from the top layer and remove it
        if(top.getComponentCount() > 1) {
            top.remove(1);
        }
    }

    //Method that remove the last panel and set the top layer second JTextField to the title Menu
    public void setToStandardMenu(){
        this.removeLastPanel();
        ((TopLayer) this.windowPanel.getComponent(1)).setTitle("Menu");
    }

    //Method that allows to know if the game is ended
    public boolean isEnded(){
        return this.ended;
    }

    //Method that allows to display the win window
    public void win(){
        this.switch_window("win");
    }

    //Method that allows to display the defeat window
    public void lose(){
        this.switch_window("loose");
    }
}
