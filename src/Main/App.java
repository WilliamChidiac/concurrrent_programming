package Main;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

import View.*;
import Controller.Growth;

public class App {
    public static void main(String[] args) {
            JFrame frame = new JFrame("Test");    

            Main_panel main_panel = new Main_panel();
            Unite_controle_view u1 = new Unite_controle_view(new Point(50, 50), Color.RED);
            Unite_controle_view u2 = new Unite_controle_view(new Point(200, 200), Color.BLUE);
            Plant_view pv1 = new Plant_view(2, 3, 4, new Point(100, 100));
            Plant_view pv2 = new Plant_view(2, 3, 4, new Point(100, 200));
            main_panel.add_unit(u2);
            main_panel.add_unit(u1);
            main_panel.add_plant(pv1);
            main_panel.add_plant(pv2);
            main_panel.setVisible(true);
            
            (new Growth()).start();;
            Refresh refresh = new Refresh(main_panel);
            refresh.start();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(main_panel);
            frame.setPreferredSize(main_panel.getPreferredSize());
            frame.pack();
            frame.setVisible(true);


    }
}