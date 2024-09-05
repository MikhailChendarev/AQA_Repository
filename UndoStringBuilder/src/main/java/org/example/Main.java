package org.example;

public class Main {

    public static void main(String[] args) {

        UndoStringBuilder usb = new UndoStringBuilder();
        usb.append("Hello").append(" my").append(" friend!")
                        .append(" How").append(" are").append(" you?");
        System.out.println(usb);

        usb.delete(0, 5);
        System.out.println(usb);

        usb.undo();
        System.out.println(usb);

        usb.undo();
        System.out.println(usb);

        usb.reverse();
        System.out.println(usb);

        usb.undo();
        System.out.println(usb);

        usb.undo();
        System.out.println(usb);

        usb.undo();
        System.out.println(usb);

    }
}
