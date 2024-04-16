package View;

import javax.swing.*;
import Modele.*;
import java.awt.*;

public class InfoShopView extends JFrame{

    public InfoShopView(EspecePlante plante) {
        setTitle(plante.getNom());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajouter des composants pour afficher les informations sur la plante
        JLabel nameLabel = new JLabel("Nom : " + plante.getNom());
        JLabel descriptionLabel = new JLabel("Description : " + plante.getDescription());
        JLabel conseil1Label = new JLabel("Conseil 1 : " + plante.getConseil1());
        JLabel conseil2Label = new JLabel("Conseil 2 : " + plante.getConseil2());
        JLabel conseil3Label = new JLabel("Conseil 3 : " + plante.getConseil3());
        JLabel prixLabel = new JLabel("Prix : " + plante.getPrix());
        JLabel timeGrowthLabel = new JLabel("Temps de croissance : " + plante.getTimeGrowth() + " jours");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.add(nameLabel);
        panel.add(descriptionLabel);
        panel.add(conseil1Label);
        panel.add(conseil2Label);
        panel.add(conseil3Label);
        panel.add(prixLabel);
        panel.add(timeGrowthLabel);

        add(panel);

        pack();
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        setVisible(true);
    }
}
