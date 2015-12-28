package com.EzyGoEzy.User;

import android.content.Context;

import com.EzyGoEzy.Providers.AccountProvider;


public class UserAccountManager implements AccountManager {

	AccountProvider mAccountProvider;
	
	public UserAccountManager(Context context)
	{
		mAccountProvider = new AccountProvider(context); 
	}
	
	@Override
	public int createUser(User user) {
		mAccountProvider.storeUser(user); 
		return 0;
	}


	@Override
	public boolean getUser(String userName,String password,User user) {
		// TODO Auto-generated method stub
		return mAccountProvider.retreiveUser(userName,password,user);
		
	}

	@Override
	public int removeUser(String userId) {
		// TODO Auto-generated method stub
		AccountProvider.deleteUser(userId);
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllUsers(UserGroup User) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
