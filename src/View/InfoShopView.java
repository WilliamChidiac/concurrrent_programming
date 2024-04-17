package View;

import javax.swing.*;
import Modele.*;
import java.awt.*;

public class InfoShopView extends JFrame{

    public InfoShopView(Plant_types plante) {
        setTitle("Informations sur " + plante.nom);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ajouter des composants pour afficher les informations sur la plante
        JLabel nameLabel = new JLabel("Nom : " + plante.nom);
        JLabel descriptionLabel = new JLabel("Description : " + plante.desc);
        JLabel conseil1Label = new JLabel("Conseil 1 : " + plante.cons1);
        JLabel conseil2Label = new JLabel("Conseil 2 : " + plante.cons2);
        JLabel conseil3Label = new JLabel("Conseil 3 : " + plante.cons3);
        JLabel prixLabel = new JLabel("Prix : " + plante.cost + " $");
        JLabel timeGrowthLabel = new JLabel("Temps de croissance : " + plante.growthTime + " jours");

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
        setVisible(false);
    }
}
