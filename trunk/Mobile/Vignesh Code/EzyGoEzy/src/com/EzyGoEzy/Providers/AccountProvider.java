package com.EzyGoEzy.Providers;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.EzyGoEzy.User.User;
import com.EzyGoEzy.Utils.AccountTypes;


public class AccountProvider extends Provider {

	public AccountProvider(Context ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}


	public static final String TABLE_USERS = "users";
	
	public static final String USERS_COLUMN_NAME_ID = "_id";
	public static final String USERS_COLUMN_NAME_USERID = "user_id";
	public static final String USERS_COLUMN_NAME_PASSWORD = "password";
	public static final String USERS_COLUMN_NAME_NAME = "full_name";
	public static final String USERS_COLUMN_NAME_EMAIL_ID = "email_id";
	public static final String USERS_COLUMN_NAME_MOBILE_NUMBER = "mobile_number";
	public static final String USERS_COLUMN_NAME_ACCOUNT_TYPE = "account_type";
	public static final String USERS_COLUMN_NAME_USER_TYPE = "user_type";
	public static final String USERS_COLUMN_NAME_BALANCE = "balance";
	
	public static final String USERS_TABLE_CREATE =
        "create table " +  TABLE_USERS + " ( " + USERS_COLUMN_NAME_ID + " integer primary key autoincrement, "
        + USERS_COLUMN_NAME_USERID  + " text unique not null, "
        + USERS_COLUMN_NAME_PASSWORD  + " text not null, "
        + USERS_COLUMN_NAME_NAME + " text not null, "
        + USERS_COLUMN_NAME_MOBILE_NUMBER + " integer not null ,"
        + USERS_COLUMN_NAME_ACCOUNT_TYPE + " integer not null ,"
        + USERS_COLUMN_NAME_EMAIL_ID + " text not null ,"
        + USERS_COLUMN_NAME_BALANCE + " integer not null );";
	
	
	
	public void storeUser(User user) {
		// TODO Auto-generated method stub
		
		ContentValues initialValues = new ContentValues();
        initialValues.put(USERS_COLUMN_NAME_USERID, user.getUserId());
        initialValues.put(USERS_COLUMN_NAME_PASSWORD, user.getPassword());
        initialValues.put(USERS_COLUMN_NAME_NAME,user.getFullName() );
        initialValues.put(USERS_COLUMN_NAME_MOBILE_NUMBER, user.getMobileNo());
        initialValues.put(USERS_COLUMN_NAME_ACCOUNT_TYPE,user.getAccountType().value());
        initialValues.put(USERS_COLUMN_NAME_EMAIL_ID,user.getEmailId() );
        initialValues.put(USERS_COLUMN_NAME_MOBILE_NUMBER, user.getMobileNo());
        initialValues.put(USERS_COLUMN_NAME_BALANCE, 0);
        open();
        db.insert(TABLE_USERS, null, initialValues);
        
    	close();
    	
    }
		
	
	public boolean retreiveUser(String userName,String password, User user) {
		// TODO Auto-generated method stub
		
		open();
		Cursor cursorUser = checkUserExists(userName,password);
		
		if(cursorUser.getCount()!=0)
		{
		String emailId = cursorUser.getString(cursorUser.getColumnIndex(USERS_COLUMN_NAME_EMAIL_ID));
		int balance = cursorUser.getInt(cursorUser.getColumnIndex(USERS_COLUMN_NAME_BALANCE));
		AccountTypes accountType = AccountTypes.lookup(cursorUser.getInt(cursorUser.getColumnIndex(USERS_COLUMN_NAME_ACCOUNT_TYPE)));
		int mobileNo = cursorUser.getInt(cursorUser.getColumnIndex(USERS_COLUMN_NAME_MOBILE_NUMBER));
		String fullName = cursorUser.getString(cursorUser.getColumnIndex(USERS_COLUMN_NAME_NAME));
		user = new User(userName, password,emailId, fullName,mobileNo,accountType);
		close();
		return true;
		}
		return false;
	}


	private Cursor checkUserExists(String userName,String password) {
		// TODO Auto-generated method stub
		Cursor cursorUser = db.query(TABLE_USERS, new String[] {
        USERS_COLUMN_NAME_USERID + "," + USERS_COLUMN_NAME_BALANCE + "," + USERS_COLUMN_NAME_EMAIL_ID + "," + USERS_COLUMN_NAME_MOBILE_NUMBER + "," + USERS_COLUMN_NAME_PASSWORD + "," + USERS_COLUMN_NAME_ACCOUNT_TYPE + "," + USERS_COLUMN_NAME_NAME},USERS_COLUMN_NAME_USERID+"=?" + " AND " + USERS_COLUMN_NAME_PASSWORD+"=?",  new String[]{userName, password}, null, null, null);
		cursorUser.moveToFirst();
		return cursorUser;
		
	}


	public static void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
}
