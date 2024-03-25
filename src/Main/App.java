package Main;

import Modele.Score_and_prices;
import View.GameInterface;

public class App {
    public static void main(String[] args) {
        //Creation of the window
        Score_and_prices sp = new Score_and_prices();
        GameInterface gameInterface = new GameInterface(sp);
        gameInterface.setVisible(true);
    }
}