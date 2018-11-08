package com.example.root.bachlorhousemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 1/29/17.
 */

public class DatabaseHandlerOne extends SQLiteOpenHelper {

    private static DatabaseHandlerOne db;
    public static synchronized DatabaseHandlerOne getInstance(Context context) {

        if (db == null) {
            db = new DatabaseHandlerOne(context.getApplicationContext());
        }
        return db;
    }


    public static  int i = 0;


    private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "controlDAtabase";

        private static final String TABLE_NAME = "allHome";
        private static final String KEY_ID = "id";
        private static final String KEY_HOMENAME = "homename";
        private static final String KEY_NUMBEROFMEMBER = "numberofmember";
        private static final String KEY_PASSWORD = "password";
        private static  final String KEY_TOTAL_BAZAR="totalbazar";
        private  static  final  String KEY_TOTAL_MEAL="totalmeal";

        private static String TABLE_NAME_1 = "subtable1";
        private static final String KEY_ID_1 = "id";
        private static final String KEY_USERNAME = "username";
        private static final String KEY_NUMBEROFMEAL = "numberofmeal";


        public DatabaseHandlerOne( Context context ) {
            super( context, DATABASE_NAME, null, DATABASE_VERSION );
        }



    @Override
        public void onCreate (SQLiteDatabase db){
            String CREATE_HOME_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_HOMENAME + " TEXT,"
                    + KEY_PASSWORD + " TEXT,"
                    + KEY_NUMBEROFMEMBER + " TEXT,"
                    + KEY_TOTAL_BAZAR + " TEXT,"
                    + KEY_TOTAL_MEAL + " TEXT" + ")";
            db.execSQL( CREATE_HOME_TABLE );


        }

    public void createTable(String temp) {
        TABLE_NAME_1 = temp;
        Log.d( TABLE_NAME_1, temp );
        SQLiteDatabase db = this.getWritableDatabase();


        String CREATE_USERDATA_TABLE = "CREATE TABLE " + TABLE_NAME_1 + "("
                + KEY_ID_1 + " INTEGER PRIMARY KEY,"
                + KEY_USERNAME + " TEXT,"
                + KEY_NUMBEROFMEAL + " TEXT" + ")";
        db.execSQL( CREATE_USERDATA_TABLE );
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate( db );
    }


    public void addHome(CreateHome home) {
        SQLiteDatabase db = this.getWritableDatabase();

        //String insert = "insert into contact(name,phoneno) values('"+contact.getName()+"','019')";
        //db.execSQL(insert);

        ContentValues value = new ContentValues();
        value.put( KEY_HOMENAME, home.getHomename() );
        value.put( KEY_PASSWORD, home.getPassword() );
        value.put( KEY_NUMBEROFMEMBER, home.getNumberofmember() );
        value.put( KEY_TOTAL_BAZAR,home.getTotalBazar() );
        value.put( KEY_TOTAL_MEAL,home.getTotalMeal() );

        db.insert( TABLE_NAME, null, value );
        db.close();

    }


    public void addUserData(UserData user) {
        SQLiteDatabase db = this.getWritableDatabase();



        ContentValues value = new ContentValues();
        value.put( KEY_USERNAME, user.getUserName() );

        value.put( KEY_NUMBEROFMEAL, user.getNumberOfMeal() );


        db.insert( TABLE_NAME_1, null, value );
        db.close();

    }


    public List<CreateHome> getAllHome() {
        List<CreateHome> allhome = new ArrayList<CreateHome>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectquery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery( selectquery, null );

        if (cursor.moveToFirst()) {
            do {
                CreateHome home = new CreateHome( Integer.parseInt( cursor.getString( 0 ) ), cursor.getString( 1 ), cursor.getString( 2 ), Integer.parseInt( cursor.getString( 3 )) ,Integer.parseInt( cursor.getString( 4 )),Integer.parseInt( cursor.getString( 5 ))  );
                allhome.add( home );
            } while (cursor.moveToNext());
        }
        db.close();
        return allhome;
    }


    public List<Member> getAllMember(String temp) {
        TABLE_NAME_1 = temp;
        List<Member> allmember = new ArrayList<Member>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectquery = "SELECT * FROM " + TABLE_NAME_1;
        Cursor cursor = db.rawQuery( selectquery, null );

        if (cursor.moveToFirst()) {
            do {
                Member member = new Member( Integer.valueOf( cursor.getString( 0 ) ), cursor.getString( 1 ), cursor.getInt( 2 ) );
                allmember.add( member );
            } while (cursor.moveToNext());
        }
        db.close();
        return allmember;

    }

    public void updateMeal(final String tablename, final List<Member> allmember) {

        final SQLiteDatabase db = this.getWritableDatabase();

        String selectquery = "SELECT * FROM " + tablename;
        Cursor cursor = db.rawQuery( selectquery, null );

        if (cursor.moveToFirst()) {
            i=0;

            do {
               // Thread t = new Thread(new Runnable() {
                   // public void run() {


                ContentValues cv = new ContentValues();
                cv.put( KEY_NUMBEROFMEAL, allmember.get( i ).getMeal() ); //These Fields should be your String values of actual column names
                db.update( tablename, cv, KEY_ID_1 + " = ?", new String[]{String.valueOf( allmember.get( i ).getId() )} );
                i++;


                   // }
                //});

               // t.start();

            } while (cursor.moveToNext());

            Log.d( "successfull ", "succssfull" );
        }

        db.close();
    }





    public void updateBazar(int id,int bazar,int meal) {

        final SQLiteDatabase db = this.getWritableDatabase();

        //String selectquery = "SELECT * FROM " + TABLE_NAME;
        ContentValues cv = new ContentValues();
          cv.put(KEY_TOTAL_BAZAR,bazar);
            cv.put(KEY_TOTAL_MEAL,meal);
        db.update(TABLE_NAME, cv, KEY_ID+" = "+id, null);

        db.close();
    }









}
