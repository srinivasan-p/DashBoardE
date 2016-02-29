package com.dashboard.util;

import com.dashboard.beans.CredentialBean;

public interface Authentication {
	String authenticate(CredentialBean user);
	String authorize(String userId);
	boolean changeLoginStatus(CredentialBean user, int loginStatus);
}
