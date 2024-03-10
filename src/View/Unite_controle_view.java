package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Point;

import Modele.Unite_controle;
import Controller.Select_unit;

public class Unite_controle_view extends JPanel{
    Point pos;
    int radius;
    Color color;
    Unite_controle unite;
    public Unite_controle_view(Point p, Color c){
        this.color = c;
        this.pos = p;
        this.radius = Constant_view.RADIUS_UNIT;
        this.unite = new Unite_controle(p);
        this.addMouseListener(new Select_unit(this));
        this.setBounds(p.x - radius, p.y - radius, radius*2, 2*radius);
        setOpaque(true);
        setBackground(Color.BLACK);
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
        this.setLocation(pos.x - radius, pos.y - radius);
        this.revalidate();
        g.setColor(this.color);
        g.fillOval(0, 0, radius*2, radius*2);
    }
}