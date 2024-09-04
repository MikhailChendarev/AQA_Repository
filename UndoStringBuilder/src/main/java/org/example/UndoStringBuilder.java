package org.example;

import java.util.Stack;

public class UndoStringBuilder {

    private char[] value;
    private int count;
    private Stack<String> history;

    public UndoStringBuilder() {
        value = new char[16];
        count = 0;
        history = new Stack<>();
    }

    private void saveHistory() {
        history.push(new String(value, 0, count));
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity > value.length * 0.75) {
            int newCapacity = value.length * 2;
            if (newCapacity - minimumCapacity < 0) {
                newCapacity = minimumCapacity * 2;
            }
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
        }
    }

    public UndoStringBuilder append(String str) {
        saveHistory();
        if (str == null) {
            throw new RuntimeException("String cannot be null");
        }
        int len = str.length();
        ensureCapacity(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }

    public UndoStringBuilder delete(int start, int end) {
        saveHistory();
        if (start < 0 || start > count || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        System.arraycopy(value, end, value, start, count - end);
        count -= (end - start);
        return this;
    }

    public UndoStringBuilder reverse() {
        saveHistory();
        for (int i = 0; i < count / 2; i++) {
            char temp = value[i];
            value[i] = value[count - 1 - i];
            value[count - 1 - i] = temp;
        }
        return this;
    }

    public void undo() {
        if (!history.isEmpty()) {
            String previousState = history.pop();
            value = previousState.toCharArray();
            count = previousState.length();
        }
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
