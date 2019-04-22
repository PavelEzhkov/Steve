package com.javacore.steve.profile;

import com.javacore.steve.common.BaseView;
import com.javacore.steve.common.Canvas;
import com.javacore.steve.common.ConsoleCanvas;

public class ProfileView extends BaseView {


    @Override
    public void draw(Canvas canvas) {

        canvas.drawSquare(10);
        canvas.drawText("Criminal Profile view");
        canvas.drawText("Name: " + ((ProfileModel) model).getName());
        canvas.drawText("Died: " + ((ProfileModel) model).isActive());
        canvas.drawText("Nickname: ");
        canvas.drawText("Criminal Family: ");
        canvas.drawText("What we know about him: ");
        canvas.drawSquare(80);

    }
    public void drawToConsole(ConsoleCanvas canvas){
        canvas.drawText("Criminal Profile view");
        canvas.drawCircleAt(67,11,10);
        canvas.drawSquareAt(58,20,19);
        canvas.draw();

    }
}
