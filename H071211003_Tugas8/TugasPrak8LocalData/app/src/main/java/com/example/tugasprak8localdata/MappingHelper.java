package com.example.tugasprak8localdata;

import android.database.Cursor;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<Note> mapCursorToArrayList(Cursor cursor) {

        ArrayList<Note> notes = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumn._ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumn.TITLE));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumn.DESCRIPTION));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumn.DATE));
            notes.add(new Note(id, title, description, date));
        }
        return  notes;
    }
}
