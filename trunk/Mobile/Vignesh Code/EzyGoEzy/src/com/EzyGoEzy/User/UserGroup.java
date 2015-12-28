package com.EzyGoEzy.User;

import java.util.ArrayList;

public class UserGroup  {
ArrayList<User> userList;
public UserGroup()
{
	userList = new ArrayList<User>();
}
void addUser(User user)
{
	userList.add(user);
}
void removeUser(int index)
{
	userList.remove(index);
}
void getUser(User user,int index)
{
	user = userList.get(index);
}
}
