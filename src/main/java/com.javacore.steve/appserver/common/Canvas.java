package com.javacore.steve.appserver.common;

public abstract class Canvas {

    protected abstract void reset();

    public abstract void draw();

    protected abstract void setSymbolAt(int x, int y, char symbol);

    public abstract void drawSquareAt(int x, int y, int size);

    public abstract void drawPaintedSquareAt(int x, int y, int size);

    public abstract void drawPaintedRectangleAt(int x, int y, int sizeX, int sizeY);

    public abstract void drawRectangleAt(int x, int y, int sizeX, int sizeY);

    public abstract void drawCircleAt(int x, int y, int radius);

    public abstract void drawTextAt(int x, int y, int size, String text);
}
