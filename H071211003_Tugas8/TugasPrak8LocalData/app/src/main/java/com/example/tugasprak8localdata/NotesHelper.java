package com.example.tugasprak8localdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NotesHelper {
    private static final String DATABASE_TABLE = DatabaseContract.TABLE_NAME;
    private static DatabaseHelper databaseHelper;
    private static SQLiteDatabase database;
    private static volatile NotesHelper INSTANCE;

    private NotesHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);

    }

    public static NotesHelper getInstance(Context context) {
        if(INSTANCE == null){
            synchronized (SQLiteOpenHelper.class) {
                if(INSTANCE == null) {
                    INSTANCE = new NotesHelper(context);
                }
            }

        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
        if(database.isOpen()){
            database.close();
        }
    }

    public ArrayList<Note> getAllNotes(){
        ArrayList<Note> notelist = new ArrayList<>();
        Cursor cursor = database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.NotesColumn._ID + " DESC"
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Note notes = getNotesFromCursor(cursor);
            notelist.add(notes);
            cursor.moveToNext();
        }
        cursor.close();
        return notelist;
    }

    private Note getNotesFromCursor(Cursor cursor) {
        Note notes = new Note();
        notes.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumn._ID)));
        notes.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumn.TITLE)));
        notes.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumn.DESCRIPTION)));
        notes.setDate(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NotesColumn.DATE)));
        return notes;
    }

    public Cursor queryById(String id) {
        return database.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.NotesColumn._ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }

    public long insert(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    public int update(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, DatabaseContract.NotesColumn._ID + " = ?", new String[]{id});
    }

    public int deleteById(String id) {
        return database.delete(DATABASE_TABLE, DatabaseContract.NotesColumn._ID + " = " + id, null);
    }

    public ArrayList<Note> searchNotes(String searchText) {
        ArrayList<Note> searchResults = new ArrayList<>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseContract.TABLE_NAME + " WHERE " + DatabaseContract.NotesColumn.TITLE + " LIKE '" + searchText + "%'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Note notes = getNotesFromCursor(cursor);
                searchResults.add(notes);
            }
        }

        if (cursor != null) {
            cursor.close();
        }

        return searchResults;
    }
}

