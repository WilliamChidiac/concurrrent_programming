package Main;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

import View.*;
import Controller.Growth;

public class App {
    public static void main(String[] args) {
        //Creation of the window
        GameInterface gameInterface = new GameInterface();
        gameInterface.setVisible(true);
    }
}