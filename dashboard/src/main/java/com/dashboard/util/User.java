package com.dashboard.util;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;

public interface User {
	String login(CredentialBean credentialsBean);
	boolean logout(String userId);
	String changePassword(CredentialBean bean ,String pass);
	String register(ProfileBean profileBean);
}
