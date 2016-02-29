package com.dashboard.util;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;

@Service("user")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserImpl implements User {

	@Autowired
	SessionFactory sessionFactory;

	public String login(CredentialBean credentialsBean) {

		return null;
	}

	public boolean logout(String userId) {
		return false;
	}

	public String changePassword(CredentialBean bean, String pass) {
		return null;

		// try {
		// Session session = sessionFactory.getCurrentSession();
		// bean.setPassword(pass);
		// session.update(bean);
		// return "SUCCESS"; // HAVE TO PRINT INVALID SOMEWHERE
		// } catch (Exception e) {
		// return "FAIL";
		// }
	}

	public String register(ProfileBean profileBean) {
		try {
			Session session = sessionFactory.getCurrentSession();
			profileBean.getpId().setStatus(9999);
			profileBean.getpId().setUpdatedBy("Registered by "+ profileBean.getpId().getpId());
			profileBean.getpId().setUpdatedOn(new Date());
			session.save(profileBean.getpId());
			profileBean.setUpdatedBy("Registered by "+ profileBean.getpId().getpId());
			profileBean.setUpdatedOn(new Date());
			session.save(profileBean);
			return "Success";
		} catch (Exception e) {
			return "Fail";
		}
	}

}
