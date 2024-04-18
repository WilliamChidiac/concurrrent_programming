package Modele;

import java.awt.Point;

import View.Constant_view;

public class Lapins_generator extends  Generator<Lapins>{
    public Lapins_generator(){
        super(Constant_modele.LAPIN_GENERATION_DELAY, Constant_modele.NB_LAPIN_INIT);
    }

    /*
     * Generate a rabbit on the lowwer right corner of the window
     * and start its movement
     */
    @Override
    public Lapins generate(){
        Point p = new Point(Constant_view.WIDTH_WINDOW, Constant_view.HEIGHT_WINDOW);
        Lapins l = new Lapins(p);
        Deplacement_lapin dl = new Deplacement_lapin(l);
        dl.start();
        return l;
    }

}
