package Modele;

import java.awt.Point;

import View.Constant_view;
import View.GameInterface;
public class Plant_generator extends Generator<Plant> {
    private GameInterface gameInterface;
    public Plant_generator( GameInterface g){
        super(Constant_modele.PLANT_GENERATION_DELAY, Constant_modele.NB_PLANT_INIT);
        gameInterface = g;
    }

    /*
     * Generate a plant
     */
    @Override
    public Plant generate(){
        Point p = new Point((int)(Math.random() * Constant_view.WIDTH_WINDOW), (int)(Math.random() * Constant_view.HEIGHT_WINDOW));
        int[] types = {0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 3};
        int type = types[(int)(Math.random() * types.length)];
        Plant_types pt = Plant_types.values()[type];
        Plant l = pt.create_plant(p);
        this.gameInterface.addPlant(l);
        return l;
    }

}