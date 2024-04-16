package Modele;

import java.awt.Point;

/**
 * A thread that moves the unit to the given point
 */
class Deplacement_jardinier extends Deplacement {
    private Unite_controle jardinier;
    /**
     * Create a new Deplacement_joueur thread
     * @param current_loc the current location of the unit
     * @param cible_loc the target location of the unit
     */
    public Deplacement_jardinier(Unite_controle jar, Point cible_loc) {
        super(cible_loc);
        this.jardinier = jar;
    }
    
    protected boolean break_condition(){
        return !this.jardinier.is_running();
    }

    /*
     * Runs a thread that moves the unit to the target location bit by bit.
     */
    @Override
    public void run() {
        Point current = jardinier.get_current_location();
        jardinier.set_movement();
        deplace(current);
        jardinier.reset_movement();
    }
}