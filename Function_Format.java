package com.company;

import java.awt.*;

public class Function_Format {
    GUI gui;
    Font arial,comicSansMS,timesNewRoman;
    String seclectedFont;

    public  Function_Format(GUI gui){
        this.gui = gui;
    }

    public void wordwrap(){
        if(gui.wordWrapON==false){
            gui.wordWrapON=true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("WordWrap is: On");
        }
        else if(gui.wordWrapON == true){
            gui.wordWrapON=false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("WordWrap is: Off");
        }

    }
    public void createFont(int fontSize){
        arial = new Font("Arial",Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS",Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman",Font.PLAIN, fontSize);

        setFont(seclectedFont);

    }
    public void setFont(String font){
        seclectedFont = font;

        switch (seclectedFont){
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
        }

    }



}
