package com.javacore.steve.profile;

import com.javacore.steve.common.BaseView;
import com.javacore.steve.common.Canvas;
import com.javacore.steve.common.CompositeView;


public class ProfileView extends CompositeView {

    private ProfileModel profileModel;


    public ProfileView(ProfileModel profileModel) {
    this.profileModel=profileModel;
    }

    public void init() {
        ProfilePhotoView photoView = new ProfilePhotoView(58, 2, 20);
        ProfileTextView profileTextView = new ProfileTextView(profileModel);
        children.add(photoView);
        children.add(profileTextView);
    }

    @Override
    public void draw(Canvas canvas) {
        for (BaseView view : children
        ) {
            view.draw(canvas);
        }
        canvas.drawRectangleAt(0, 0, 80, 200);

        canvas.draw();
    }
}
