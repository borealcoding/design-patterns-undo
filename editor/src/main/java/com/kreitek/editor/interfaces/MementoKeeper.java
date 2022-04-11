package com.kreitek.editor.interfaces;

import com.kreitek.editor.memento.Memento;
import java.util.ArrayList;

public interface MementoKeeper {
    Memento saveMemento(ArrayList<String> documentLines);
}
