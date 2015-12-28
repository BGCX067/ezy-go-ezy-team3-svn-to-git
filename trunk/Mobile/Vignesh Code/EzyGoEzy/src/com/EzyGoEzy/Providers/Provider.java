package com.EzyGoEzy.Providers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


abstract class Provider  {
	private static final String TAG = "EzyGoEzyDatabaseHandler";

	private static final String DATABASE_NAME = "ezygoezy.db";
	private static final int DATABASE_VERSION = 2;
	private static final String TABLE_NOTIFICATIONS = "notifications";
	 
	 
	private Context context = null;  
	private DatabaseHelper DBHelper;
	protected SQLiteDatabase db;



	public Provider(Context ctx)
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db)
		{
			db.execSQL(AccountProvider.USERS_TABLE_CREATE);
		}

		

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + AccountProvider.TABLE_USERS);          
            onCreate(db);
		}
	}
		 public void open() throws SQLException
		    {
		        db = DBHelper.getWritableDatabase();
		    }
		 
		     
		    public void close()
		    {
		        DBHelper.close();
		    }    
		    
	
		  
	}

