package com;

import javax.swing.*;
import java.awt.*;

public class DisplayGUI extends JFrame{

    private JPanel MainDisplayPanel;

    public DisplayGUI(){
        //Set the Content Panel to our JPanels
        setContentPane(MainDisplayPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setPreferredSize(new Dimension(600, 400));
        pack();
    }

    public static void main(String[] args){
        DisplayGUI page = new DisplayGUI();
        page.setVisible(true);
    }
}
