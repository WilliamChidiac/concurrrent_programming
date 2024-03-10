package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import View.Main_panel;
import View.Unite_controle_view;
import Modele.Unite_controle;

/**
 * Move the previously selected unit to the mouse position
 */
public class Move_unit extends MouseAdapter {
    private Main_panel main_panel;

    public Move_unit(Main_panel main_panel) {
        this.main_panel = main_panel;
    }

    /**
     * Move the selected unit to the mouse position
     */
    @Override 
    public void mouseClicked(MouseEvent e) {
        Unite_controle_view unite_panel = (Unite_controle_view) main_panel.get_unit_selected();
        if (unite_panel != null) {
            Unite_controle unite = unite_panel.get_unite();
            unite.move_unite(e.getPoint());
        }
        e.consume();
    }
}