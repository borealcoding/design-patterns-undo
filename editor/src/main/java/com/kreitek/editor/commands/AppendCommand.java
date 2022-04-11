package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;
    private EditorCaretaker editorCaretaker;

    public AppendCommand(EditorCaretaker editorCaretaker, String text) {
        this.editorCaretaker = editorCaretaker;
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.add(text);
        editorCaretaker.push(saveMemento(documentLines));
    }

    private Memento saveMemento(ArrayList<String> documentLines) {
        ArrayList<String> copyDocumentLines = (ArrayList<String>) documentLines.clone();
        return new Memento(documentLines);
    }
}
