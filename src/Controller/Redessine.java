package Controller;

import View.View;

public class Redessine extends Thread{
    View a;

    public Redessine(View a){
        this.a = a;
    }
    @Override
    public void run(){
        //redraw the screen every 500ms
        while(true){
            a.revalidate();
            a.repaint();
            try { Redessine.sleep(500); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }

}
