package ru.innotech.lesson02;

import java.util.EmptyStackException;
import java.util.Stack;

// список операций для выполнения отмены
public class HistoryUndo {
    private Stack<Undoable> undos = new Stack<>();
    private boolean flagUndo = false;

    public boolean isFlagUndo() {
        return flagUndo;
    }

    public void setFlagUndo(boolean flagUndo) {
        this.flagUndo = flagUndo;
    }

    public void add(Undoable met){
        undos.push(met);
    }
    public Undoable get() {
        if (undos.size() == 0) throw new RuntimeException("Отсутствуют действия для отмены");
        return undos.pop();
    }

}
