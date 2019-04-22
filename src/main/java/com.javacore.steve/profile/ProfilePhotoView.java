package com.javacore.steve.profile;

import com.javacore.steve.common.BaseView;
import com.javacore.steve.common.Canvas;

public class ProfilePhotoView  extends BaseView {

    private int x;
    private int y;
    private int size;


    public ProfilePhotoView(int x, int y, int size){
        this.x=x;
        this.y=y;
        this.size=size;
    }


    @Override
    public void draw(Canvas canvas) {
       // super.drawSquare();
    }
}
