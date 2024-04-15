package Modele;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

public class Unite_controle {
    private static int id_counter = 0;
    private static HashMap<Integer, Unite_controle> all_unit = new HashMap<Integer, Unite_controle>();
    private int id;
    private Point current_location;
    private boolean is_running = false;
    private boolean ready_to_move = true;

    /**
     * Get all the units
     * @return all the units
     */
    public static Collection<Unite_controle> get_all_unit() {
        return all_unit.values();
    }

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
     * Set the current location of the unit
     * @param current_location the current location of the unit
     */
    public boolean is_running() {
        return is_running;
    }

    /**
     * Set the current location of the unit
     * @param current_location the current location of the unit
     */
    public boolean ready_to_move() {
        return ready_to_move;
    }

    /**
     * Set the current location of the unit
     * @param current_location the current location of the unit
     */
    public void set_movement() {
        ready_to_move = false;
        is_running = true;
    }

    /**
     * Set the current location of the unit
     * @param current_location the current location of the unit
     */
    public void reset_movement() {
        ready_to_move = true;
        is_running = false;
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
        Deplacement_jardinier dp = new Deplacement_jardinier(this, point);
        dp.start();
    }
}