package Modele;

import java.awt.Point;
import java.util.HashMap;
import java.lang.Math;

public class Unite_controle {
    private static int id_counter = 0;
    public static HashMap<Integer, Unite_controle> all_unit = new HashMap<Integer, Unite_controle>();
    private int id;
    private Point current_location;
    private boolean is_running = false;
    private boolean ready_to_move = true;

    public Unite_controle(Point current_location) {
        this.id = id_counter++;
        this.current_location = current_location;
        all_unit.put(id, this);
    }

    /**
     * Get the unit with the given id
     * @param id the id of the unit
     * @return the unit with the given id
     */
    public static Unite_controle getUnite(int id) {
        return all_unit.get(id);
    }

    /**
     * Get the current location of the unit
     * @return the current location of the unit
     */
    public Point get_current_location() { 
        return current_location;
    }

    /**
     * Get the id of the unit
     * @return the id of the unit
     */
    public int get_id() {
        return id;
    }

    /**
     * Move the unit to the given point
     * @param point the point to move the unit to
     */
    public void move_unite(Point point) {
        if (is_running) {
            is_running = false;
            while (!ready_to_move) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Deplacement_joueur dp = new Deplacement_joueur(current_location, point);
        dp.start();
    }

    /**
     * Set the is_running of the unit
     * @param is_running the current location of the unit
     */
    public void setIs_running(boolean is_running) {
        this.is_running= is_running;
    }

    /**
     * A thread that moves the unit to the given point
     */
    class Deplacement_joueur extends Thread {
        private Point current;
        private Point cible;

        /**
         * Create a new Deplacement_joueur thread
         * @param current_loc the current location of the unit
         * @param cible_loc the target location of the unit
         */
        public Deplacement_joueur(Point current_loc, Point cible_loc) {
            this.current = current_loc;
            this.cible = cible_loc;
        }

        /**
         * Get the direction of the given point
         * @param p the point to get the direction of
         * @return the direction of the given point
         */
        private int direction(int p) {
            if (p > 0)
                return 1;
            return -1;
        }
        
        /*
         * Runs a thread that moves the unit to the target location bit by bit.
         */
        @Override
        public void run() {
            is_running = true;
            ready_to_move = false;
            int x_dir = direction(cible.x - current.x);
            int y_dir = direction(cible.y - current.y);
            while (true) {
                boolean no_change = true;
                try {
                    Thread.sleep(Constant_modele.THREAD_DELAY_UNITE);
                    if (Math.abs(this.current.y - this.cible.y) > (Constant_modele.VITESSE_DEPLACEMENT_UNITE / 2)) {
                        no_change = false;
                        current.y += y_dir * Constant_modele.VITESSE_DEPLACEMENT_UNITE;
                    }
                    if (Math.abs(this.current.x - this.cible.x) > (Constant_modele.VITESSE_DEPLACEMENT_UNITE / 2)) {
                        no_change = false;
                        current.x += x_dir * Constant_modele.VITESSE_DEPLACEMENT_UNITE;
                    } 
                    if (no_change || is_running == false) {
                        ready_to_move = true;
                        is_running = false;
                        break;
                    }              
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}