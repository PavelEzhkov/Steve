package com.javacore.steve.profile;

import com.javacore.steve.common.ConsoleCanvas;

public class ProfileController {
    private ProfileModel profileModel;
    private ProfileView view;
    private ProfileStore store;
    private ConsoleCanvas canvas;

   /* {
        store.INSTANSE.loadDate();
        view = new ProfileView();
        canvas = new ConsoleCanvas(15,15);
    }*/

    public void showProfile(int id) {
        ProfileModel model = store.INSTANSE.getProfile(id);
        if (model == null) {
            System.out.println("No record found  with id: " + id);
        } else {
            view.setModel(model);
            canvas = new ConsoleCanvas(80,200);
            view.drawToConsole(canvas);
        }
    }
    public void showProfile(String text) {
            canvas = new ConsoleCanvas(80,200);
            view = new ProfileView();
            view.drawToConsole(canvas);
    }


    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    public ProfileView getView() {
        return view;
    }

    public void setView(ProfileView view) {
        this.view = view;
    }
}
