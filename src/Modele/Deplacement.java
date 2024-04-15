package Modele;

import java.awt.Point;

public abstract class Deplacement extends Thread{
    protected Point cible;

    public Deplacement(Point cible_loc) {
        this.cible = cible_loc;
    }

    /**
     * Get the direction of the given point
     * @param p the point to get the direction of
     * @return the direction of the given point
     */
    protected int direction(int p) {
        if (p > 0)
            return 1;
        return -1;
    }
    
    protected boolean deplace(Point current){ 
            int x_dir = direction(cible.x - current.x);
            int y_dir = direction(cible.y - current.y);
            while (true) {
                boolean no_change = true;
                try {
                    Thread.sleep(Constant_modele.THREAD_DELAY_DEPLACEMENT);
                    if (Math.abs(current.y - this.cible.y) > (Constant_modele.VITESSE_DEPLACEMENT_UNITE / 2)) {
                    no_change = false;
                    current.y += y_dir * Constant_modele.VITESSE_DEPLACEMENT_UNITE;
                    }
                    if (Math.abs(current.x - this.cible.x) > (Constant_modele.VITESSE_DEPLACEMENT_UNITE / 2)) {
                    no_change = false;
                    current.x += x_dir * Constant_modele.VITESSE_DEPLACEMENT_UNITE;
                    } 
                    if (no_change || this.break_condition()) {
                        return no_change;
                    }              
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    protected abstract boolean break_condition();

    
    @Override
    public abstract void run();
}
