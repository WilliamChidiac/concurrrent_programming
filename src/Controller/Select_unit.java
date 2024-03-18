package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import View.Main_panel;
import View.Unite_controle_view;

public class Select_unit extends MouseAdapter {
    private Unite_controle_view unite_panel;
    
    public Select_unit( Unite_controle_view unite) {
        this.unite_panel = unite;
    }

    /*
     * Select the unit when clicked
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Main_panel main_panel = (Main_panel) unite_panel.getParent();
            main_panel.set_unit_selected(unite_panel);    
            e.consume();
        } catch (Exception ex) {
            System.out.println("Unite not correctly linked to main panel.\n" + ex);
        }
    }
}