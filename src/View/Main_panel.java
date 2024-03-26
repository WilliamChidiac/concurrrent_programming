package View;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Dimension;

import Controller.Move_unit;

/**
 * Main panel of the application
 */
public class Main_panel extends JPanel  {
    public Main_panel() {
        Dimension dim = new Dimension();
        dim.setSize(Constant_view.WIDTH_WINDOW, Constant_view.HEIGHT_WINDOW);
        this.setPreferredSize(dim);
        setLayout(null);
        addMouseListener(new Move_unit());
    }

    /**
     * Get the game interface
     * @return the game interface
     */
    public GameInterface get_game_interface(){
        return (GameInterface) SwingUtilities.getWindowAncestor(this);
    }

    /**
     * Add a unit to the panel
     * @param unite the unit to add
     */
    public void add_unit(Unite_controle_view unite) {
        this.add(unite);
    }
    public void add_plant(Plant_view plant) {
        this.add(plant);
    }

    /**
     * Make the unit stay, interrupt the movement, remove the gardener panel and empty the selected unit
     */
    public void stay(){
        GameInterface gameInterface = get_game_interface();
        gameInterface.removeGardenerPanel();
        Unite_controle_view.stop_movement();
    }
}