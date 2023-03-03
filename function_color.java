package com.company;

import java.awt.*;

public class function_color {
    GUI gui;
    public function_color(GUI gui){
        this.gui = gui;


    }
    public void changecolor(String color){
        switch (color){
            case "White":
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.BLACK);
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.WHITE);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(Color.BLUE);
                gui.textArea.setBackground(Color.BLUE);
                gui.textArea.setForeground(Color.WHITE);
                break;
        }


    }
}
