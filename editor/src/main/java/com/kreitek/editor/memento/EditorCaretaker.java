package com.kreitek.editor.memento;

import java.util.ArrayList;

public class EditorCaretaker {
    ArrayList<Memento> mementos = new ArrayList<>();

    public void push(Memento memento) {
        mementos.add(memento);
    }

    public Memento pop() {
        if (mementos.size() > 0) {
            mementos.remove(mementos.size() - 1);
            if (mementos.size() != 0) { return mementos.get(mementos.size() - 1); }
        }
        return null;
    }
}
