package com.EzyGoEzy;

import com.EzyGoEzy.User.User;

public class CurrentUser {

public static User mUser;
public static boolean isSet = false;

public static void set(User user)
{
	mUser = user;
	isSet = true;
	
}
	
}
