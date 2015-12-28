package com.EzyGoEzy.Utils;

public enum UserTypes {
GENERAL(0), ADMIN(1);

 private int code;

 private UserTypes(int c) {
   code = c;
 }

 public int getCode() {
   return code;
 }


}
