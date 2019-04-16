package com.javacore.steve.common;

public class ConsoleCanvas extends Canvas {
    @Override
    public void drawText(String text) {
        System.out.println(text);
    }


    @Override
    public void drawSquare(int size) {
        if (size<2){
            System.out.println("No square of such size allowed");
        }
        System.out.print("\n");
        for (int i = 0; i < size; i++) {
            System.out.print("#");
        }
        System.out.println();
        for (int i = 1; i < size-1; i++) {
            System.out.print("#");
            for (int j = 1; j < size-1; j++) {
                System.out.print(" ");
            }
            System.out.println("#");
        }
        for (int i = 0; i < size; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
