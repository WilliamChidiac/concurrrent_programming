package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Modele.Plant_types;
import Modele.Score_and_prices;

/*
 * This class is a JPanel that represents a shop for one specific type of plant 
 */
public class PlantShop extends JPanel{
    private static ArrayList<PlantShop> plantShopList = new ArrayList<PlantShop>();
    public static void setEnabled(int money){
        for(PlantShop ps : plantShopList){
            if(ps.money_needed < money){
                ps.buy.setEnabled(true);
            }else{
                ps.buy.setEnabled(false);
            }
        }
    }

    private InfoShopView infoview;
    private JButton buy;
    private int money_needed;

    public PlantShop(Plant_types pt, Score_and_prices sp, Main_panel mp){
        super(new BorderLayout());
        this.money_needed = pt.cost;
        plantShopList.add(this);
        infoview = new InfoShopView(pt);

        JButton info = new JButton("Informations");
        info.addActionListener(e -> {
            infoview.setVisible(true);
        });
        buy = new JButton("Acheter: " + pt.cost + " $");
        buy.addActionListener(e -> {
            if (sp.getMoney() > pt.cost){
                sp.removeMoney(pt.cost);
                Point coordinate = (Point) Unite_controle_view.get_selected_unit().get_unite().get_current_location().clone();
                Plant_view pv = new Plant_view(pt.create_plant(coordinate),sp);
                mp.add(pv);
            }
        });
        JPanel button_Panel = new JPanel(new GridLayout(1, 2));
        button_Panel.add(info);
        button_Panel.add(buy);
        this.add(button_Panel, BorderLayout.SOUTH);
        this.setBackground(pt.color);
        this.setPreferredSize(new Dimension(275, 150));
        JTextArea zone = new JTextArea(pt.nom);
        zone.setEditable(false);
        this.add(zone, BorderLayout.NORTH);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    
}