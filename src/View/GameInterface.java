package View;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.Growth;
import Modele.Score_and_prices;
import Modele.Plant;

public class GameInterface extends JFrame{
    //Attribute that contains the principal panel of the game
    private JPanel windowPanel;

    //Attribute that contains the panel of the gardener
    private Gardener_menu gardenerPanel;

    //Attribute that contains the panel of the plant
    private Plant_menu plantPanel;

    //Attribute that contains the panel of the rabbit
    private JPanel rabbitPanel;

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
        this.gardenerPanel = new Gardener_menu(map, sp);

        //Fuse the panel of the map and the panel of the buttonsPanel in one main panel
        this.windowPanel = new JPanel(new BorderLayout());
        windowPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        //Add the map panel to the mainPanel
        windowPanel.add(map, BorderLayout.CENTER);
        //Add the menu panel to the mainPanel
        windowPanel.add(new TopLayer("Menu"), BorderLayout.EAST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.windowPanel);
        this.pack();
    }

    //Method that allows to update the score in the top layer
    public void updateScore(int score) {
        //Get the top layer
        TopLayer top = (TopLayer) this.windowPanel.getComponent(1);
        //Update the text of the first JTextField with the new score
        top.updateScore(score);
    }


    //Method that allows to remove the last panel added and add the gardenerMenu to the topLayer
    public void addGardenerMenu(){
        //Remove the last panel added to the topLayer
        this.removeLastPanel();
        //Add the gardenerMenu to the topLayer
        ((TopLayer) this.windowPanel.getComponent(1)).add(this.gardenerPanel, BorderLayout.CENTER);
        //Set the title of the topLayer to Gardener
        ((TopLayer) this.windowPanel.getComponent(1)).setTitle("Gardener");
        this.revalidate();
    }

    //Method that allows to remove the last panel added and add the plantMenu to the topLayer
    public void addPlantMenu(Plant p){
        //Remove the last panel added to the topLayer
        this.removeLastPanel();
        this.plantPanel = new Plant_menu(p);
        //Add the plantMenu to the topLayer
        ((TopLayer) this.windowPanel.getComponent(1)).add(this.plantPanel, BorderLayout.CENTER);
        this.revalidate();
    }

    //Method that remove the last panel added to the topLayer if there is one
    public void removeLastPanel(){
        //Get the top layer
        TopLayer top = (TopLayer) this.windowPanel.getComponent(1);

        //Check if there is a panel to remove from the top layer and remove it
        if(top.getComponentCount() > 1) {
            top.remove(1);
            this.revalidate();
        }
    }

    //Method that remove the last panel and set the top layer second JTextField to the title Menu
    public void setToStandardMenu(){
        this.removeLastPanel();
        ((TopLayer) this.windowPanel.getComponent(1)).setTitle("Menu");
    }
}
