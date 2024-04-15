package Modele;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

import View.Constant_view;

public class Deplacement_lapin extends Deplacement{
    private Lapins lapin;
    private int id;
    private Plant closest_plant = null;
    private static int id_counter = 0;
    private static HashMap<Integer, Deplacement_lapin> all_lapins = new HashMap<Integer, Deplacement_lapin>();

    public Deplacement_lapin(Lapins lapin) {
        super(lapin.get_current_location());
        this.lapin = lapin;
        this.id = id_counter++;
        all_lapins.put(id, this);
    }

    public Deplacement_lapin(Point lapin_loc){
        super(lapin_loc);
        this.lapin = new Lapins(lapin_loc);
        this.id = id_counter++;
        all_lapins.put(id, this);
    }


    private void update_cible(){
        Collection<Unite_controle> jardinier = Unite_controle.get_all_unit();
        Collection<Plant> plantes = Plant.getAllPlants();
        Point cible_plant = new Point(10000000, 1000000000);
        Point cible_jard = new Point(10000000, 1000000000);
        Point lapin_pos = lapin.get_current_location();
        for (Unite_controle unite : jardinier) {
            Point unite_pos = unite.get_current_location();
            if (unite_pos.distance(lapin_pos) < cible_jard.distance(lapin_pos)) {
                cible_jard = unite_pos;
            }
        }
        for (Plant plant : plantes) {
            Point plant_pos = plant.getPosition();
            if (plant_pos.distance(lapin_pos) < cible_plant.distance(lapin_pos) && cible_jard.distance(plant_pos) > Constant_modele.DISTANCE_MINIMUM_GARDENER_PLANT){
                cible_plant = plant_pos;
                closest_plant = plant;
            }
        }
        if (cible_jard.distance(lapin_pos) < cible_plant.distance(lapin_pos)) {
            cible = new Point(lapin_pos.x - cible_plant.x, lapin_pos.y - cible_plant.y);
        }else{
            cible = cible_plant;
        }

    }

    @Override
    protected boolean break_condition(){
        return closest_plant.isGathered();
    }

    @Override
    public void run(){
        Point current = lapin.get_current_location();
        while (lapin.is_alive()) {
            update_cible();
            if (deplace(current)){ // if the rabbit reached the plant

            }else{ // if the plant was gathered before he could eat it.

            }
        }
        cible = new Point((int) (Constant_view.WIDTH_WINDOW*1.25), (int) (Constant_view.HEIGHT_WINDOW*1.25));
        deplace(current);
    }


}
