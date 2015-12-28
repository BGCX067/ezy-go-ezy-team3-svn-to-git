package com.EzyGoEzy.Utils;

import java.util.TreeMap;

public enum AccountTypes {

		  POSTPAID(0), PREPAID(1);
		  
		  private int _value;
		  
		  AccountTypes(int value) {
		    _value = value;
		  }
		  
		  public int value() {
		    return _value;
		  }

		  private static TreeMap<Integer, AccountTypes> _map;
		  static {
			_map = new TreeMap<Integer, AccountTypes>();
		    for (AccountTypes accountTypes: AccountTypes.values()) {
		    	_map.put(new Integer(accountTypes.value()), accountTypes);
		    }
		  }
		  
		  public static AccountTypes lookup(int value) {
			  return _map.get(new Integer(value));
		  }
		}

