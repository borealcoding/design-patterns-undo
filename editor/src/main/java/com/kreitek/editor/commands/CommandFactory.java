package com.kreitek.editor.commands;

import com.kreitek.editor.BadCommandException;
import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.ExitException;
import com.kreitek.editor.memento.EditorCaretaker;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();
    private EditorCaretaker editorCaretaker = new EditorCaretaker();

    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(editorCaretaker, args[1]);
            case "u" -> createUpdateCommand(editorCaretaker, args[1], args[2]);
            case "d" -> createDeleteCommand(editorCaretaker, args[1]);
            case "undo" -> createUndoCommand(editorCaretaker);
            default -> throw new ExitException();
        };
    }

    private Command createAppendCommand(EditorCaretaker editorCaretaker, String text) {
        return new AppendCommand(editorCaretaker, text);
    }

    private Command createUpdateCommand(EditorCaretaker editorCaretaker, String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(editorCaretaker, text, number);
    }

    private Command createDeleteCommand(EditorCaretaker editorCaretaker, String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(editorCaretaker, number);
    }

    private Command createUndoCommand(EditorCaretaker editorCaretaker) {
        return new UndoCommand(editorCaretaker);
    }

}
