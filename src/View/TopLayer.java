package View;

import Modele.Constant_modele;

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
        this.textPanel = new JPanel(new GridLayout(4,1));
        this.textPanel.setBackground(Color.darkGray);

        //Create the JTextField with the time, score, the money and the title

        //Create the JTextField with the time
        JTextField time = new JTextField("Time : " + Constant_view.TIME);
        time.setEditable(false);
        time.setHorizontalAlignment(JTextField.CENTER);
        time.setBackground(Color.LIGHT_GRAY);
        this.textPanel.add(time);

        //Create the JTextField with the score
        JTextField score = new JTextField("Score : 0/" + Constant_modele.SCORE_OBJECTIVE);
        score.setEditable(false);
        score.setHorizontalAlignment(JTextField.CENTER);
        score.setBackground(Color.LIGHT_GRAY);
        this.textPanel.add(score);

        //Create the JTextField with the money
        JTextField money = new JTextField("Money : 0");
        money.setEditable(false);
        money.setHorizontalAlignment(JTextField.CENTER);
        money.setBackground(Color.LIGHT_GRAY);
        this.textPanel.add(money);

        //Create the JTextField with the title
        JTextField top = new JTextField(str);
        top.setEditable(false);
        top.setHorizontalAlignment(JTextField.CENTER);
        top.setBackground(Color.LIGHT_GRAY);

        //Add the all the JTextField to the textpanel
        this.textPanel.add(top);

        //Add the textpanel to the top layer
        this.add(this.textPanel, BorderLayout.NORTH);
    }

    //Method setTime that changes the text of the first JTextField with the new time
    public void updateTime(int time){
        ((JTextField) this.textPanel.getComponent(0)).setText("Time : " + time);
    }

    //Method setScore that changes the text of the first JTextField with the new score
    public void updateScore(int score){
        ((JTextField) this.textPanel.getComponent(1)).setText("Score : " + score+ "/" + Constant_modele.SCORE_OBJECTIVE);
    }

    //Method setMoney that changes the text of the second JTextField with the new money
    public void updateMoney(int money){
        ((JTextField) this.textPanel.getComponent(2)).setText("Money : " + money);
    }

    //Method setTitle that changes the text of the second JTextField with the new title
    public void setTitle(String str){
        ((JTextField) this.textPanel.getComponent(3)).setText(str);
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

        //Button to change the title
        JButton b1 = new JButton("Change title");
        b1.addActionListener(e -> top.setTitle("Menu"));
        buttonsPanel.add(b1);

        //Button to change the time
        JButton b2 = new JButton("Change time");
        b2.addActionListener(e -> top.updateTime(10));
        buttonsPanel.add(b2);

        //Button to change the score
        JButton b3 = new JButton("Change score");
        b3.addActionListener(e -> top.updateScore(10));
        buttonsPanel.add(b3);

        //Button to change the money
        JButton b4 = new JButton("Change money");
        b4.addActionListener(e -> top.updateMoney(10));
        buttonsPanel.add(b4);

        top.add(buttonsPanel, BorderLayout.CENTER);
        frame.add(top);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
