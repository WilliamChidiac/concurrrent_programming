package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import Controller.Select_unit;
import Modele.Unite_controle;

public class Unite_controle_view extends JPanel{
    private int radius;
    private Color color;
    private Unite_controle unite;
    private static Unite_controle_view selected_unit = null;
    public Unite_controle_view(Point p, Color c){
        this.color = c;
        this.radius = Constant_view.RADIUS_UNIT;
        this.unite = new Unite_controle(p);
        this.addMouseListener(new Select_unit(this));
        this.setBounds(p.x - radius, p.y - radius, radius*2, 2*radius);
        setOpaque(false);
    }

    public static Unite_controle_view get_selected_unit() {
        return selected_unit;
    }

    public static void set_selected_unit(Unite_controle_view selected_unit) {
        Unite_controle_view.selected_unit = selected_unit;
    }

    public static void stop_movement(){
        selected_unit.unite.setIs_running(false);
        selected_unit = null;
    }

    /**
     * Get the unit linked to the JPanel
     * @return the position of the unit
     */
    public Unite_controle get_unite() {
        return unite;
    }

    /**
     * Paints the unit and updates its position
     */
    @Override 
    public void paint(Graphics g) {
        super.paintComponent(g);
        Point pos = this.unite.get_current_location();
        this.setLocation(pos.x - radius, pos.y - radius);
        this.revalidate();
        g.setColor(this.color);
        g.fillOval(0, 0, radius * 2, radius * 2);
    }
}