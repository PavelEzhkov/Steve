package com.javacore.steve.consolservice.profile;

import com.javacore.steve.appserver.common.BaseView;
import com.javacore.steve.appserver.common.Canvas;
import com.javacore.steve.appserver.profile.ProfileModel;

public class ProfileTextView extends BaseView {

    private ProfileModel profileModel;

    public ProfileTextView(ProfileModel profileModel) {
        this.profileModel =profileModel;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawTextAt(2, 2, 52, profileModel.getFirstName()+ " "+ profileModel.getLastName());
        canvas.drawTextAt(2, 4, 52, "Born: " + profileModel.getDateOfBirth());
        canvas.drawTextAt(2,6, 52, profileModel.isActive()?"Died: "+profileModel.getDateOfDeath():"Still alive");
        canvas.drawTextAt(2, 8, 52, "Nickname: " + profileModel.getNickname());
        canvas.drawTextAt(2, 10, 52, "Crime Family: " + profileModel.getCrimeFamelyId());
        canvas.drawTextAt(2,12,52, "DNA Sample: <DNA>");
        canvas.drawTextAt(2,14,52, "What we know about him: " + "Number of crimes: " + profileModel.getNumberOfCrimes());
    }
}
