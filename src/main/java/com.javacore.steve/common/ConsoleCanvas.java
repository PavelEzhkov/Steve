package com.javacore.steve.common;

public class ConsoleCanvas extends Canvas {

    private char[][] pixels;
    private int width;
    private int height;

    public  ConsoleCanvas(int width, int height){
        this.height=height;
        this.width=width;
        init();
    }

    public void init(){
        pixels= new char[height][width];
        reset();
    }

    private void reset(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j]='.';
            }
        }
    }

    public void draw(){
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(pixels[i][j]);
            }
        }
    }


    public void setSymbolAt(int x, int y, char symbol){
        pixels[y][x] = symbol;
    }

    @Override
    public void drawText(String text) {
        System.out.println(text);
    }


    @Override
    public void drawSquare(int size) {

    }

    public void drawSquareAt(int x, int y, int size){
        //to DO
        for (int i = x; i < x+size; i++) {
            setSymbolAt(i,y,'#');
        }
        for (int i = y+1; i < y+size-1; i++){
            setSymbolAt(x,i,'#');
            setSymbolAt(x+size-1,i,'#');
        }
        for (int i = x; i < x+size; i++) {
            setSymbolAt(i,y+size-1,'#');
        }
    }
    public void drawCircleAt(int x, int y, int radius){

        for (int i = x-radius+1; i < x+radius; i++) {
            setSymbolAt(i,y,'#');
        }


        //aaaaa help
        for (int i = 1; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                setSymbolAt(x-radius+j,y+i,'#');
                setSymbolAt(x-radius+j,y-i,'#');
                ;
                //radius--;
            }

        }
    }
    public void drawTestAt(int x, int y, String text){

    }
}
