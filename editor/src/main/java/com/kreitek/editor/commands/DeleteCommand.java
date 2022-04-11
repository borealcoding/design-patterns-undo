package com.kreitek.editor.commands;

import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.interfaces.MementoKeeper;
import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class DeleteCommand implements Command, MementoKeeper {
    private final int lineNumber;
    private EditorCaretaker editorCaretaker;

    public DeleteCommand(EditorCaretaker editorCaretaker, int lineNumber) {
        this.editorCaretaker = editorCaretaker;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.remove(lineNumber);
        editorCaretaker.push(saveMemento(documentLines));
    }

    public Memento saveMemento(ArrayList<String> documentLines) {
        return new Memento(documentLines);
    }
}
