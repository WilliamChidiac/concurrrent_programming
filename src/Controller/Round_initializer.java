package Controller;

import java.awt.Color;
import java.awt.Point;

import Modele.Constant_modele;
import Modele.Lapins_generator;
import Modele.Score_and_prices;
import Modele.Plant_generator;
import View.Main_panel;
import View.GameInterface;
import View.Unite_controle_view;

public class Round_initializer extends Thread {
    private GameInterface gameInterface;
    private Lapins_generator lapins_generator;
    private Plant_generator plant_generator;
    private Score_and_prices sp;
    private int time = 300;

    public Round_initializer(GameInterface g, Score_and_prices sp){
        this.gameInterface = g;
        g.round_init(this);
        Main_panel main_panel = g.getMain_panel();
        this.lapins_generator = new Lapins_generator();
        this.plant_generator = new Plant_generator(g);
        Unite_controle_view u1 = new Unite_controle_view(new Point(0, 0), Color.BLUE);
        Unite_controle_view u2 = new Unite_controle_view(new Point(50, 0), Color.RED);
        main_panel.add_unit(u1);
        main_panel.add_unit(u2);
    } 
    
    @Override
    public void run(){
        this.plant_generator.start();
        (new Growth()).start();
        this.lapins_generator.start();
        while(true){
            try{
                Thread.sleep(1000);
                this.time--;
                this.gameInterface.updateTime(this.time);
                if(this.time <=0){
                    break;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if (sp.getScore() >= Constant_modele.SCORE_OBJECTIVE){
            this.gameInterface.win();
        } else {
            this.gameInterface.lose();
        }
    }
    



}