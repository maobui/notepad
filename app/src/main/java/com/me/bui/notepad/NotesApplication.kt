package com.me.bui.notepad

import android.app.Application

import com.me.bui.notepad.data.DataStore

class NotesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DataStore.init(this)
    }
}
