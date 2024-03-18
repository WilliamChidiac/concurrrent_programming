package View;

import javax.swing.*;
import java.awt.*;
public class TopLayer extends JPanel{
    /**
     * Constructor that creates the top layer with the title
     * @param str the title of the top layer
     * @return a top layer
     */
    public TopLayer(String str){
        this.setLayout( new BorderLayout());
        this.setBackground(Color.darkGray);

        JTextField top = new JTextField(str);
        top.setEditable(false);
        top.setHorizontalAlignment(JTextField.CENTER);
        top.setBackground(Color.LIGHT_GRAY);
        top.setPreferredSize(new Dimension(WIDTH/4, HEIGHT/32));
        this.add(top, BorderLayout.CENTER);
    }

    /**
     * Main method to test the TopLayer class
     * @param args
     */
    public static void main(String[] args) {
        //Test the TopLayer class
        JFrame frame = new JFrame();
        JPanel top = new TopLayer("Gardener's "+"1"+" actions :");

        //Panel buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(10,2));
        buttonsPanel.add(new JButton("Market"));
        buttonsPanel.add(new JButton("Market2"));
        buttonsPanel.add(new JButton("Market3"));
        buttonsPanel.add(new JButton("Market4"));

        top.add(buttonsPanel, BorderLayout.SOUTH);
        frame.add(top);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
