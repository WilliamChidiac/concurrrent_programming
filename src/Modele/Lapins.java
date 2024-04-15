package Modele;

import java.awt.Point;

public class Lapins extends Thread {
    private Point position;
    private Boolean is_alive;
    public Lapins(Point pos) {
        this.position = pos;
        is_alive = true;
        this.start();
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