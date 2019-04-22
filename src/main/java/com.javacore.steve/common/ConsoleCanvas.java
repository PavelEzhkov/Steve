package com.javacore.steve.common;

public class ConsoleCanvas extends Canvas {

    private char[][] pixels;
    private int width;
    private int height;

    public ConsoleCanvas(int width, int height) {
        this.height = height;
        this.width = width;
        init();
    }

    private void init() {
        pixels = new char[height][width];
        reset();
    }

    private void reset() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = ' ';
            }
        }
    }

    public void draw() {
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(pixels[i][j]);
            }
        }
    }


    private void setSymbolAt(int x, int y, char symbol) {
        pixels[y][x] = symbol;
    }

    @Override
    public void drawText(String text) {
        System.out.println(text);
    }


    @Override
    public void drawSquare(int size) {

    }

    public void drawSquareAt(int x, int y, int size) {
        //to DO
        for (int i = x; i < x + size; i++) {
            setSymbolAt(i, y, '#');
        }
        for (int i = y + 1; i < y + size - 1; i++) {
            setSymbolAt(x, i, '#');
            setSymbolAt(x + size - 1, i, '#');
        }
        for (int i = x; i < x + size; i++) {
            setSymbolAt(i, y + size - 1, '#');
        }
    }

    public void drawPaintedSquareAt(int x, int y, int size) {
        //to DO
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                setSymbolAt(i, j, '#');
            }
        }

    }

    public void drawPaintedRectangleAt(int x, int y, int sizeX, int sizeY) {
        //to DO
        for (int i = x; i < x + sizeX; i++) {
            for (int j = y; j < y + sizeY; j++) {
                setSymbolAt(i, j, '#');
            }
        }
    }


    public void drawRectangleAt(int x, int y, int sizeX, int sizeY) {
        //to DO
        for (int i = x; i < x + sizeX; i++) {
            setSymbolAt(i, y, '#');
        }
        for (int i = y + 1; i < y + sizeY - 1; i++) {
            setSymbolAt(x, i, '#');
            setSymbolAt(x + sizeX - 1, i, '#');
        }
        for (int i = x; i < x + sizeX; i++) {
            setSymbolAt(i, y + sizeY - 1, '#');
        }
    }

    public void drawCircleAt(int x, int y, int radius) {

        for (int i = x-radius+1; i <x+radius ; i++) {
            for (int j = y-radius+1; j <y+radius ; j++) {
                //0.8 only for nicer picture =)
                if((Math.pow(i-x,2)+(Math.pow(j-y,2)))<radius*radius*0.8)setSymbolAt(i, j, '#');
            }
        }
    }

    public void drawTestAt(int x, int y, int size, String text) {
        char[] chars = text.toCharArray();
        int lineBreak =0;
        for (int i = 0; i < chars.length; i++) {
            if((i-size*lineBreak)<size-1)
                setSymbolAt(x+i-size*lineBreak,y+lineBreak,chars[i]);
                else {
                    lineBreak++;
                    setSymbolAt(x+i-size*lineBreak,y+lineBreak,chars[i]);}
        }
    }
}
