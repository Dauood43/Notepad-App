package com.company;

import java.util.Stack;

public class Undo_Redo {
    GUI gui;


    public Undo_Redo(GUI gui){
        this.gui=gui;



    }

    private static Stack<String> undoStack = new Stack<>();
    private static Stack<String> redoStack = new Stack<>();


    public static void undo() {
        if (!undoStack.empty()) {
            redoStack.push(GUI.textArea.getText());
            GUI.textArea.setText(undoStack.pop());
        }
    }

    public static void redo() {
        if (!redoStack.empty()) {
            undoStack.push(GUI.textArea.getText());
            GUI.textArea.setText(redoStack.pop());
        }
    }
    public void saveText() {
        undoStack.push(GUI.textArea.getText());
        redoStack.clear();
    }

}
