package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import View.Unite_controle_view;
import Modele.Unite_controle;

/**
 * Move the previously selected unit to the mouse position
 */
public class Move_unit extends MouseAdapter {

    /**
     * Move the selected unit to the mouse position
     */
    @Override 
    public void mouseClicked(MouseEvent e) {
        Unite_controle_view unite_panel = Unite_controle_view.get_selected_unit();
        if (unite_panel != null) {
            Unite_controle unite = unite_panel.get_unite();
            unite.move_unite(e.getPoint());
        }
        e.consume();
    }
}