package com.xyzsoft.emanage;

public class xlsChangeCheck {

	public boolean changeCheck(int newValue, int oldValue) {
		if (newValue > oldValue) {
			return true;
		} else {
			return false;
		}
	}

}
