package Main;

import javax.swing.JFrame;

import Controller.Growth;
import Controller.PlantClick;
import Controller.Redessine;
import Model.AllPlants;
import Model.Plant;
import View.View;

public class App {
    // Main method
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Plant Growth");
        Plant p = new Plant(2, 3, 4, 5, 100, 100);
        AllPlants allPlants = new AllPlants();
        allPlants.addPlant(p);
        View v = new View(allPlants);
        PlantClick pc = new PlantClick(allPlants);
        v.addMouseListener(pc);
        frame.add(v);
        Growth g = new Growth(allPlants);
        Redessine r = new Redessine(v);
        r.start();
        g.start();

        frame.pack();
        frame.setVisible(true);
    }
}