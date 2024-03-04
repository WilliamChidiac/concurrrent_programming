import javax.swing.*;
import java.awt.*;

public class GameInterface {
    //Constant WIDTH that definies the weight of the window, it has to be superior as the WIDTHMAP
    int WIDTH = 400;

    //Constant HEIGHT that definies the height of the window, it has to be superior as the HEIGHTMAP
    int HEIGHT = 400;
    // Constant HEIGHTMAP that defines the height of the map
    int HEIGHTMAP = 300;

    // Constant WIDTHMAP that defines the width of the map
    int WIDTHMAP = 300;
    //Constant BUTTONSIZE that defines the size of the buttons in the game
    int BUTTONSIZE = 100;

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));

        // Shows the panel
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

}
