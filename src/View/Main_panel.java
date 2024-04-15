package View;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import Controller.Move_unit;
import Modele.Lapins;

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
        gameInterface.setToStandardMenu();
        Unite_controle_view.stop_movement();
    }

    public void paint_lapin(Graphics g, Point p){
        int radius_lapin = Constant_view.RADIUS_LAPIN;
        g.setColor(Constant_view.LAPIN_COLOR);
        g.fillOval(p.x - radius_lapin, p.y - radius_lapin, radius_lapin * 2, radius_lapin * 2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Lapins lapin : Lapins.get_all_lapins()) {
            paint_lapin(g, lapin.get_current_location());
        }
    }
}