package com.kreitek.editor.commands;

import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.interfaces.MementoKeeper;
import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class UpdateCommand implements Command, MementoKeeper {
    private final String text;
    private final int lineNumber;
    private EditorCaretaker editorCaretaker;

    public UpdateCommand(EditorCaretaker editorCaretaker, String text, int lineNumber) {
        this.editorCaretaker = editorCaretaker;
        this.text = text;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (documentLines.size() > lineNumber) {
            documentLines.set(lineNumber, text);
        }
        else {
            documentLines.add(text);
        }
        editorCaretaker.push(saveMemento(documentLines));
    }

    public Memento saveMemento(ArrayList<String> documentLines) {
        return new Memento(documentLines);
    }
}
