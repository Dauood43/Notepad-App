package com.company;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String fileName;
    String fileaddress;
    public Function_File(GUI gui){
        this.gui=gui;

    }
    public void newfile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileaddress = null;

    }
   public void open(){
       FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD);
       fd.setVisible(true);

       if(fd.getFile()!=null){
           fileName=fd.getFile();
           fileaddress=fd.getDirectory();
           gui.window.setTitle(fileName);
       }
       try {
           BufferedReader br= new BufferedReader(new FileReader(fileaddress+fileName));
           gui.textArea.setText("");
           String line = null;
           while ((line = br.readLine())!=null){
               gui.textArea.append(line + "\n");
           }
           br.close();

       }catch (Exception e){
           System.out.println("File not Opened");
       }

   }
   public void save(){
        if(fileName==null){
            saveas();
        }
        else{
            try{
                FileWriter fw = new FileWriter(fileaddress + fileName);
                fw.write(gui.textArea.getText());
                fw.close();
            }catch (Exception e){
                System.out.println("Something is wrong");
            }
        }


   }
   public void saveas(){
        FileDialog fd = new FileDialog(gui.window,"Save As",FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileaddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try{
            FileWriter fw = new FileWriter(fileaddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();


        }catch (Exception e){
            System.out.println("Something is Wrong");
        }
   }
   public void exit(){
       System.exit(0);
   }




}




