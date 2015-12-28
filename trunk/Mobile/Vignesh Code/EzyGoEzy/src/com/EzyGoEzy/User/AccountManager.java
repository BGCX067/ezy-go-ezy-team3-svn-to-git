package com.EzyGoEzy.User;

public interface AccountManager {

public int createUser(User user);
public int authenticateUser(String username,String password);
public int updateUser(User user);
public int removeUser(String username); 
public boolean getUser(String username,String password,User user);
public int getAllUsers(UserGroup userGroup);

}
