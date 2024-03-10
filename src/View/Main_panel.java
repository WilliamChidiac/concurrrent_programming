package View;

import javax.swing.JPanel;
import java.awt.Dimension;

import Controller.Move_unit;

/**
 * Main panel of the application
 */
public class Main_panel extends JPanel  {
    private JPanel unit_selected;
    public Main_panel() {
        this.unit_selected = null;
        Dimension dim = new Dimension();
        dim.setSize(Constant_view.WIDTH_WINDOW, Constant_view.HEIGHT_WINDOW);
        this.setPreferredSize(dim);
        setLayout(null);
        addMouseListener(new Move_unit(this));
        
    }
    /**
     * Get the selected unit
     * @return the selected unit
     */
    public JPanel get_unit_selected() {
        return unit_selected;
    }

    /**
     * Set the selected unit
     * @param unit_selected the selected unit
     */
    public void set_unit_selected(JPanel unit_selected) {
        this.unit_selected = unit_selected;
    }

    /**
     * Add a unit to the panel
     * @param unite the unit to add
     */
    public void add_unit(Unite_controle_view unite) {
        this.add(unite);
    }
}