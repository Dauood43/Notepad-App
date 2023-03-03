package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {
    //Text Area Coding
    JFrame window;
    static JTextArea textArea;
    JScrollPane scrollPane;
    //Menubar Coding
    JMenuBar menubar;
    JMenu menuFile,menuEdit,menuFormat,menuColor;
    //FileMenu Coding
    JMenuItem inew,iopen,isave,isaveas,iexit;
//    Edit Menu
    JMenuItem iUndo,iRedo;

    //Format Menu Coding
    boolean wordWrapON = false;
    JMenuItem iWrap,iFontArial,iFontCSMS,iFontTNR;
    JMenu menuFont;
    // Color Menu Coding
    JMenuItem icolor1,icolor2,icolor3;

//    Linked CLasses

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    function_color color = new function_color(this);
    Undo_Redo undo_redo = new Undo_Redo(this);

//    Main Function

    public static void main(String args[]){
        new GUI();


    }
    public GUI(){
        createWindow();
        createtextArea();
        createMenubar();
        createFilemenu();
        createEditMenu();
        createFormatmenu();
        format.seclectedFont = "Arial";
        format.createFont(20);
        createColorMenu();
        color.changecolor("White");
        undo_redo.undo();
        undo_redo.redo();
        undo_redo.saveText();
        window.setVisible(true);

    }

//    Frame Coding


  public   void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
   public void createtextArea(){
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

//    Menubar Coding

   public void createMenubar(){
        menubar = new JMenuBar();
        window.setJMenuBar(menubar);

         menuFile = new JMenu("File");
         menubar.add(menuFile);

         menuEdit = new JMenu("Edit");
         menubar.add(menuEdit);

         menuFormat = new JMenu("Format");
         menubar.add(menuFormat);

         menuColor = new JMenu("Color");
         menubar.add(menuColor);
    }
//    FileMenu Coding
    public void createFilemenu(){

        inew= new JMenuItem("New");
        inew.addActionListener(this);
        inew.setActionCommand("New");
        menuFile.add(inew);

        iopen= new JMenuItem("Open");
        iopen.addActionListener(this);
        iopen.setActionCommand("Open");
        menuFile.add(iopen);


        isave= new JMenuItem("Save");
        isave.addActionListener(this);
        isave.setActionCommand("Save");
        menuFile.add(isave);


        isaveas= new JMenuItem("Save as");
        isaveas.addActionListener(this);
        isaveas.setActionCommand("Save as");
        menuFile.add(isaveas);



        iexit= new JMenuItem("Exit");
        iexit.addActionListener(this);
        iexit.setActionCommand("Exit");
        menuFile.add(iexit);
    }
//    EditMenu Coding

    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);




    }
//    Format Menu Coding
    public void createFormatmenu(){
        iWrap = new JMenuItem("WordWrap is: OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("WordWrap");
        menuFormat.add(iWrap);

        menuFont= new JMenu("Font");
        menuFormat.add(menuFont);
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

    }
//    ColorMenu Coding
    public void createColorMenu(){
        icolor1 = new JMenuItem("White");
        icolor1.addActionListener(this);
        icolor1.setActionCommand("White");
        menuColor.add(icolor1);

        icolor2 = new JMenuItem("Black");
        icolor2.addActionListener(this);
        icolor2.setActionCommand("Black");
        menuColor.add(icolor2);

        icolor3 = new JMenuItem("Blue");
        icolor3.addActionListener(this);
        icolor3.setActionCommand("Blue");
        menuColor.add(icolor3);


    }


//    Action Event performer
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New": file.newfile();break;
            case "Open": file.open();break;
            case "Save": file.save();break;
            case "Save as": file.saveas();break;
            case "Exit": file.exit();break;
            //format Cases
            case "WordWrap": format.wordwrap();break;
            case "Arial": format.setFont(command);break;
            case "Comic Sans MS": format.setFont(command);break;
            case "Times New Roman": format.setFont(command);break;
//            color cases
            case "White": color.changecolor(command);break;
            case "Black": color.changecolor(command);break;
            case "Blue": color.changecolor(command);break;
//            Edit Cases
            case "Undo": Undo_Redo.undo();break;
            case "Redo": Undo_Redo.redo();break;







        }

    }
}
