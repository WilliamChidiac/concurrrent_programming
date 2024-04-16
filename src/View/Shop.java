package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Modele.EspecePlante;
import Modele.Score_and_prices;

public class Shop extends JFrame{

    private Main_panel map;
    private Score_and_prices sp;

    public JPanel creePanFleur(EspecePlante plante){

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Ajout boutton Informations et Acheter
        JButton info = new JButton("Informations");
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoShopView infowindow = new InfoShopView(plante);
            }
        });
        JButton acheter = new JButton("Acheter");
        JPanel buttonPanel = new JPanel(new GridLayout(1,2));
        buttonPanel.add(info);
        buttonPanel.add(acheter);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(plante.getCouleur()); // Couleur du carré
                g.fillRect(0, 0, getWidth(), getHeight()); // Dessin du carré
            }
        };

        imagePanel.setPreferredSize(new Dimension(150, 150)); // Taille du carré (à ajuster si nécessaire)
        panel.add(imagePanel, BorderLayout.CENTER);

        // Ajout Caractéristique
        JTextArea zoneTexte = new JTextArea(plante.getNom());
        zoneTexte.setEditable(false);
        panel.add(zoneTexte, BorderLayout.NORTH);

        return panel;


    }
    public Shop(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);

        //Panel that contains the buttons without interaction
        JPanel buttonsShop = new JPanel(new GridLayout(2,2)); // Div en 2 lignes 2 colonnes

        // Ajout des panels

        EspecePlante rose = new EspecePlante();
        rose.initRose();
        JPanel RoseP = creePanFleur(rose);
        buttonsShop.add(RoseP);

        EspecePlante tulipe = new EspecePlante();
        tulipe.initTulipe();
        JPanel TulipeP = creePanFleur(tulipe);
        buttonsShop.add(TulipeP);

        EspecePlante magnolia = new EspecePlante();
        magnolia.initMagnolia();
        JPanel MagnoliaP = creePanFleur(magnolia);
        buttonsShop.add(MagnoliaP);

        EspecePlante lys = new EspecePlante();
        lys.initLys();
        JPanel LysP = creePanFleur(lys);
        buttonsShop.add(LysP);

        buttonsShop.setBackground(Color.pink);

        buttonsShop.setPreferredSize(new Dimension(Constant_view.WIDTH_WINDOW/2, Constant_view.WIDTH_WINDOW/2));
        buttonsShop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));



        TopLayer top = new TopLayer("Shop's actions :");
        top.add(buttonsShop, BorderLayout.SOUTH);
        this.add(top);

        this.pack();
    }

    public void addPlant(Main_panel map, Score_and_prices sp, int xp, EspecePlante plante, int money_collected){
        Point coordinate = (Point) Unite_controle_view.get_selected_unit().get_unite().get_current_location().clone();
        Plant_view pv = new Plant_view(xp, plante, coordinate, sp, money_collected);
        map.add_plant(pv);
    }

    /**
     * Main method to test the Shop_menu class
     * @param args
     */
    public static void main(String[] args) {
        //Test the visual of Shop_menu class
        JFrame frame = new Shop();
        frame.setVisible(true);
    }
}
