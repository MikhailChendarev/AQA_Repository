package org.example;

import java.util.Stack;

public class UndoStringBuilder {

    private StringBuilder stringBuilder;

    private Stack<String> history;

    public UndoStringBuilder() {
        stringBuilder = new StringBuilder();
        history = new Stack<>();
    }

    private void saveHistory() {
        history.push(stringBuilder.toString());
    }

    public UndoStringBuilder append(String string) {
        saveHistory();
        stringBuilder.append(string);
        return this;
    }

    public UndoStringBuilder delete(int start, int end) {
        saveHistory();
        stringBuilder.delete(start, end);
        return this;
    }

    public UndoStringBuilder insert(int offset, String str) {
        saveHistory();
        stringBuilder.insert(offset, str);
        return this;
    }

    public UndoStringBuilder reverse() {
        saveHistory();
        stringBuilder.reverse();
        return this;
    }
    // методов много, дальше по аналогии.
}