package com.kreitek.editor.commands;

import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private EditorCaretaker editorCaretaker;

    public UndoCommand(EditorCaretaker editorCaretaker) {
        this.editorCaretaker = editorCaretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        ArrayList<String> tempDocumentLines = restoreMemento(editorCaretaker.pop());
        documentLines.clear();
        if(tempDocumentLines != null) { documentLines.addAll(tempDocumentLines); }
    }

    private ArrayList<String> restoreMemento(Memento memento) {
        if (memento != null) {
            return new ArrayList<>(memento.getState());
        } else {
            return null;
        }
    }
}
