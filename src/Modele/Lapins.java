package Modele;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;

public class Lapins extends Thread {
    private static int id_counter = 0;
    private final int id;
    private static HashMap<Integer, Lapins> all_lapins = new HashMap<Integer, Lapins>();
    private Point position;
    private Boolean is_alive;
    public Lapins(Point pos) {
        this.id = id_counter++;
        this.position = pos;
        is_alive = true;
        all_lapins.put(id, this);
        this.start();
    }    
    public static Lapins get_lapin(int id) {
        return all_lapins.get(id);
    }
    public static Collection<Lapins> get_all_lapins() {
        return all_lapins.values();
    }
    public static void remove_lapin(int id) {
        all_lapins.remove(id);
    }

    public int get_id() {
        return this.id;
    }

    public Point get_current_location() {
        return this.position;
    }

    public void kill() {
        this.is_alive = false;
    }

    public Boolean is_alive() {
        return this.is_alive;
    }

    @Override 
    public void run(){
        try {
            Thread.sleep(Constant_modele.LAPIN_LIFETIME_SECONDS*1000);
            this.kill();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}