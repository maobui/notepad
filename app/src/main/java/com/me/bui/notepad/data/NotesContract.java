package com.me.bui.notepad.data;

import android.provider.BaseColumns;

public final class NotesContract {
    private NotesContract() {}

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NoteTable._TABLE_NAME + " (" +
            NoteTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            NoteTable.TEXT + " TEXT, " +
            NoteTable.IS_PINNED + " INTEGER, " +
            NoteTable.CREATED_AT + " INTEGER, " +
            NoteTable.UPDATED_AT + " INTEGER" +
            ")";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + NoteTable._TABLE_NAME;

    public static final String SQL_QUERY_ALL =
            "SELECT * FROM NOTE ORDER BY " + NoteTable.CREATED_AT + " DESC";

    public interface NoteTable extends BaseColumns {
        String _TABLE_NAME = "notes";
        String TEXT = "text";
        String IS_PINNED = "is_pinned";
        String CREATED_AT = "created_at";
        String UPDATED_AT = "updated_at";
    }
}
