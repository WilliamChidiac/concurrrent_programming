package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class TopLayer extends JPanel{

    //Attribute that contains the JPanel with a gridLayout with the textual characteristics
    private JPanel textPanel;

    /**
     * Constructor that creates the top layer with the title
     * @param str the title of the top layer
     */
    public TopLayer(String str){
        //Create the top layer
        super(new BorderLayout());
        this.setBackground(Color.darkGray);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.setPreferredSize(new Dimension(Constant_view.WIDTH_WINDOW/4, Constant_view.HEIGHT_WINDOW));

        //Create the textpanel with the textual characteristics
        this.textPanel = new JPanel(new GridLayout(3,1));
        this.textPanel.setBackground(Color.darkGray);

        //Create the two JTextField with the score and the title
        JTextField score = new JTextField("Score : 0");
        score.setEditable(false);
        score.setHorizontalAlignment(JTextField.CENTER);
        score.setBackground(Color.LIGHT_GRAY);
        this.textPanel.add(score);

        JTextField money = new JTextField("Money : 0");
        money.setEditable(false);
        money.setHorizontalAlignment(JTextField.CENTER);
        money.setBackground(Color.LIGHT_GRAY);
        this.textPanel.add(money);

        JTextField top = new JTextField(str);
        top.setEditable(false);
        top.setHorizontalAlignment(JTextField.CENTER);
        top.setBackground(Color.LIGHT_GRAY);
        //Add the two JTextField to the textpanel
        this.textPanel.add(top);

        //Add the textpanel to the top layer
        this.add(this.textPanel, BorderLayout.NORTH);
    }

    //Method setTitle that changes the text of the second JTextField with the new title
    public void setTitle(String str){
        ((JTextField) this.textPanel.getComponent(2)).setText(str);
    }

    //Method setScore that changes the text of the first JTextField with the new score
    public void updateScore(int score){
        ((JTextField) this.textPanel.getComponent(0)).setText("Score : " + score);
    }

    //Method setMoney that changes the text of the second JTextField with the new money
    public void updateMoney(int money){
        ((JTextField) this.textPanel.getComponent(1)).setText("Money : " + money);
    }

    /**
     * Main method to test the TopLayer class
     */
    public static void main(String[] args) {
        //Test the TopLayer class
        JFrame frame = new JFrame();
        TopLayer top = new TopLayer("Gardener's "+"1"+" actions :");

        //Panel buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(10,2));
        JButton b1 = new JButton("Change title");
        b1.addActionListener(e -> top.setTitle("Menu"));
        buttonsPanel.add(b1);

        buttonsPanel.add(new JButton("Market2"));
        buttonsPanel.add(new JButton("Market3"));
        buttonsPanel.add(new JButton("Market4"));

        top.add(buttonsPanel, BorderLayout.CENTER);
        frame.add(top);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
