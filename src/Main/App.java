package Main;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import Modele.Score_and_prices;
import View.GameInterface;
import View.Refresh;


public class App {
    public static void main(String[] args) {
        //Creation of the window
        Score_and_prices sp = new Score_and_prices();
        GameInterface gameInterface = new GameInterface("Gardeners vs Rabbits",sp);

        // Create a KeyStroke for the escape key
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        // Create an AbstractAction that disposes the frame
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        // Map the escape KeyStroke to the escape Action
        gameInterface.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        gameInterface.getRootPane().getActionMap().put("ESCAPE", escapeAction);

        //Creation of the refresh thread
        Refresh refresh = new Refresh(gameInterface);
        refresh.start();

        //Display the window
        gameInterface.setVisible(true);
    }
}