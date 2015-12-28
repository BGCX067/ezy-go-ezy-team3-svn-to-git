package com.EzyGoEzy.User;


import com.EzyGoEzy.Utils.AccountTypes;
import com.EzyGoEzy.Utils.UserTypes;


public class User {

String mUserId;
 String mFullName;
 int mMobileNo;
 String mPassword;
 AccountTypes mAccountType;
 String mEmailId;
 UserTypes mUserType;
private String mUserName;
 public User(String userName, String password,String emailId, String fullName, int mobileNo,AccountTypes accountType)
 {
	mUserId = userName;
	mPassword = password;
	mFullName = fullName;
	mAccountType = accountType;
	mMobileNo = mobileNo;
	mEmailId = emailId;
 }
 
 public void setMobileNo(int mobileNo)
 {
	mMobileNo = mobileNo; 
 }
 public int getMobileNo()
 {
	 return mMobileNo;
 }
 public String getUserId()
 {
	 return mUserId;
 }
 public String getFullName()
 {
	 return mFullName;
 }
 public String getEmailId()
 {
	 return mEmailId;
 }
 public String setEmailId()
 {
	 return mEmailId;
 }
 public void setFullName(String fullName)
 {
	 fullName = mFullName;
 }
 public void setUserName(String userName)
 {
	 mUserName = userName;
 }
 public AccountTypes getAccountType()
 {
	 return mAccountType;
 }
 public void setAccountType(AccountTypes accountType)
 {
	 mAccountType = accountType;
 }
 public void setPassword(String password)
 {
	 password = mPassword;
 }
 public  String getPassword()
 {
	return mPassword;
 }
 public void setUserType(UserTypes userType)
 {
	 mUserType = userType;
 }
 public  UserTypes getUserType()
 {
	 return mUserType;
 }
 }

 
 

