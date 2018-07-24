package com.me.bui.notepad;

import android.app.Application;

import com.me.bui.notepad.data.DataStore;

public class NotesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataStore.init(this);
    }
}
