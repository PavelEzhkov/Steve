package com.javacore.steve.profile;

import com.javacore.steve.common.BaseView;
import com.javacore.steve.common.Canvas;
import com.javacore.steve.common.CompositeView;
import com.javacore.steve.common.ConsoleCanvas;

public class ProfileView extends CompositeView {

    public void init(){
        ProfilePhotoView photoView = new ProfilePhotoView(30,2,10);
        children.add(photoView);
    }


    @Override
    public void draw(Canvas canvas) {
        for (BaseView view: children
             ) {
            view.draw(canvas);
        }
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
        canvas.drawRectangleAt(0,0,80,200);
        canvas.drawRectangleAt(55,1,23,40);
        canvas.drawCircleAt(66,11,10);
        canvas.drawPaintedSquareAt(57,20,19);
        canvas.drawTestAt(3,1, 52, "Name: Jon Snow lord of North and dafksafdklfjadsjfkjsdlfjdskfjkdsfjkjljgae;adsfk;angk;ammre;;kdsagfadfsgdrfag");

        canvas.draw();

    }
}
