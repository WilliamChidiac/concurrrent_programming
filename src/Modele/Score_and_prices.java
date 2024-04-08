package Modele;

import View.GameInterface;

public class Score_and_prices {
    private GameInterface gameInterface;
    public int score;

    //Constant representing the score objective to win the game
    public static final int SCORE_OBJECTIVE = 100;

    public Score_and_prices(GameInterface gm) {
        this.score = 0;
        this.gameInterface = gm;
    }

    public Score_and_prices() {
        this.score = 0;
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
}
