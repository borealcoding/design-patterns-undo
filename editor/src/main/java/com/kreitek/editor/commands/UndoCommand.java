package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class UndoCommand implements Command {


    @Override
    public void execute(ArrayList<String> documentLines) {
        int lastNumberLine = documentLines.size() - 1;
        System.out.println("Se deshace la ultima linea: " + lastNumberLine);
        documentLines.remove(lastNumberLine);
    }
}
