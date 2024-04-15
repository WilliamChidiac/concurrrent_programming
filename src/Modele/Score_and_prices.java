package Modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import View.GameInterface;

public class Score_and_prices {
    private GameInterface gameInterface;
    public int score;
    public int money;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    //Constant representing the score objective to win the game
    public static final int SCORE_OBJECTIVE = 100;

    public Score_and_prices(GameInterface gm) {
        this.score = 0;
        this.money = 0;
        this.gameInterface = gm;
    }

    public Score_and_prices() {
        this.score = 0;
        this.money = 0;
        this.gameInterface = null;
    }

    public void setGameInterface(GameInterface gm) {
        this.gameInterface = gm;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
        gameInterface.updateScore(this.score);

        //If the score is greater than the score objective, the player wins
        if(this.score >= SCORE_OBJECTIVE){
            //Call the win method of the game interface
            gameInterface.win();
        }
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        int oldMoney = this.money;
        this.money += money;
        gameInterface.updateMoney(this.money);
        this.pcs.firePropertyChange("money", oldMoney, this.money);
    }

    public void removeMoney(int money) {
        int oldMoney = this.money;
        this.money -= money;
        gameInterface.updateMoney(this.money);
        this.pcs.firePropertyChange("money", oldMoney, this.money);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

}
