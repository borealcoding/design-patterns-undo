package com.kreitek.editor.interfaces;

import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<String> documentLines);
}
