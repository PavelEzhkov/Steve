package com.javacore.steve.consolservice.profile;

import com.javacore.steve.appserver.common.BaseView;
import com.javacore.steve.appserver.common.Canvas;
import com.javacore.steve.appserver.common.CompositeView;
import com.javacore.steve.appserver.profile.ProfileModel;


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
