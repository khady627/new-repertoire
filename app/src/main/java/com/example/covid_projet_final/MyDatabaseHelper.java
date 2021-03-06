package com.example.covid_projet_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Version base de données
    private static final int DATABASE_VERSION = 1;

    // nom base de données
    private static final String DATABASE_NAME = "Personne";

    // Nom Table : Note.
    private static final String TABLE_Personne = "Personne";

    private static final String COLUMN_Email = "email";
    private static final String COLUMN_nom = "nom";
    private static final String COLUMN_prenom = "prenom";
    private static final String COLUMN_tel = "tel";
    private static final String COLUMN_Adresse = "adresse";

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creation Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script.
        String script = "CREATE TABLE " + TABLE_Personne + "(" + COLUMN_prenom + " String PRIMARY KEY,"
                + COLUMN_nom + " String," + COLUMN_Adresse + " String," + COLUMN_Email + " String,"
                + COLUMN_tel + " String" +
                ")";
        // Execution Script.
        db.execSQL(script);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");
        // Supprimer la table plus ancienne si elle existait
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Personne);

        // Créer à nouveau des tables
        onCreate(db);
    }


    // Si la table Note ne contient aucune donnée
    // par défaut, insérer 2 enregistrements.
   /* public void createDefaultNotesIfNeed()  {
        int count = this.getNotesCount();
        if(count ==0 ) {
            Note note1 = new Note("Tout d'abord, voir Android ListView",
                    "Voir l'exemple Android ListView dans com.example.sqlitedemo");
            Note note2 = new Note("Apprendre Android SQLite",
                    "Voir l'exemple Android SQLite dans com.example.sqlitedemo");
            this.addNote(note1);
            this.addNote(note2);
        }
    }*/


    public void addNote(Note note) {
        Log.i(TAG, "MyDatabaseHelper.addNote ... " + note.getPrenom());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_prenom, note.getPrenom());
        values.put(COLUMN_nom, note.getNom());
        values.put(COLUMN_Adresse, note.getAdresse());
        values.put(COLUMN_Email, note.getEmail());
        values.put(COLUMN_tel, note.getTelephone());

        // Insertion d'une ligne
        db.insert(TABLE_Personne, null, values);

        // Fermeture de la connexion à la base de données
        db.close();
    }


    /*public Note getNote(int id) {
        Log.i(TAG, "MyDatabaseHelper.getNote ... " + pers);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Personne, new String[] { COLUMN_prenom,
                        COLUMN_nom, COLUMN_Adresse,COLUMN_Email,COLUMN_tel }, COLUMN_prenom + "=?",
                new String[] { String.valueOf(personne) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Note note = new Note(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return note
        return note;
    }
*/

    public List<Note> getAllNotes() {
        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );

        List<Note> noteList = new ArrayList<Note>();
        // Sélectionner toute la requête
        String selectQuery = "SELECT  * FROM " + TABLE_Personne;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // boucle sur toutes les lignes et ajout à la liste
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                //note.setPrenom(Integer.parseInt(cursor.getString(0)));
                note.setPrenom(cursor.getString(1));
                note.setNom(cursor.getString(2));
                note.setAdresse(cursor.getString(3));
                note.setEmail(cursor.getString(4));
                note.setTelephone(cursor.getString(5));
                // Ajouter une note à la liste
                noteList.add(note);
            } while (cursor.moveToNext());
        }

        // return note list
        return noteList;
    }

    public int getNotesCount() {
        Log.i(TAG, "MyDatabaseHelper.getNotesCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_Personne;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }


  /*  public int updateNote(Note note) {
        Log.i(TAG, "MyDatabaseHelper.updateNote ... "  + note.getPrenom());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_prenom, note.getPrenom());
        values.put(COLUMN_nom, note.getNom());
        values.put(COLUMN_Adresse, note.getAdresse());
        values.put(COLUMN_Email, note.getEmail());
        values.put(COLUMN_tel, note.getTelephone());

        // mise à jour de la ligne
        return db.update(TABLE_Personne, values,
                new String[]{String.note.getPrenom()});
    }*/

   /* public void deleteNote(Note note) {
        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + note.getPrenom() );

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTE, COLUMN_NOTE_ID + " = ?",
                new String[] { String.valueOf(note.getNoteId()) });
        db.close();
    }*/

}