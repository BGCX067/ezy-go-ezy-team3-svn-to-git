package com.EzyGoEzy.Utils;

import java.util.TreeMap;

public enum ErrorCodes {
	 SUCCESS(0), FAILURE(1);
	  
	  private int _value;
	  
	  ErrorCodes(int value) {
	    _value = value;
	  }
	  
	  public int value() {
	    return _value;
	  }

	  private static TreeMap<Integer,ErrorCodes> _map;
	  static {
		_map = new TreeMap<Integer, ErrorCodes>();
	    for (ErrorCodes errorCodes: ErrorCodes.values()) {
	    	_map.put(new Integer(errorCodes.value()),errorCodes);
	    }
	  }
	  
	  public static ErrorCodes lookup(int value) {
		  return _map.get(new Integer(value));
	  }
}
