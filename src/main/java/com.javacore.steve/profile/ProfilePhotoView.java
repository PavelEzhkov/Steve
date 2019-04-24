package com.javacore.steve.profile;

import com.javacore.steve.common.BaseView;
import com.javacore.steve.common.Canvas;

public class ProfilePhotoView  extends BaseView {

    private int x;
    private int y;
    private int sizeX;



    public ProfilePhotoView(int x, int y, int sizeX){
        this.x=x;
        this.y=y;
        this.sizeX=sizeX;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangleAt(x,y,sizeX,sizeX/2*3);
        canvas.drawCircleAt(x+sizeX/2,y+sizeX/2-1,sizeX/2-2);
        canvas.drawPaintedRectangleAt(x+2,y+sizeX-3,sizeX-4, sizeX/2+2);// super.drawSquare();
    }
}
