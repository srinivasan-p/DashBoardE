package com.dashboard.util;

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

//		try {
//			if(userId.equalsIgnoreCase(null) || userId.equalsIgnoreCase("") )
//			{
//				return false;	
//			}
//			else
//			{
//			Session session = sessionFactory.getCurrentSession();
//			CredentialBean cb = (CredentialBean) session.get(
//					CredentialBean.class, userId);
//			cb.setStatus(0);
//			session.update(cb);
//
//			return true; // HAVE TO PRINT INVALID SOMEWHERE
//		} 
//		}catch (Exception e) {
//			return false;
//		}
	}

	public String changePassword(CredentialBean bean, String pass) {
		return null;

//		try {
//			Session session = sessionFactory.getCurrentSession();
//			bean.setPassword(pass);
//			session.update(bean);
//			return "SUCCESS"; // HAVE TO PRINT INVALID SOMEWHERE
//		} catch (Exception e) {
//			return "FAIL";
//		}
	}

	public String register(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//	public String register(ProfileBean profileBean) {
//		System.out.println("INSIDE");
//
//		try {
//if(profileBean.equals(null) || (profileBean.getCity().equalsIgnoreCase(null)) || profileBean.getCity().equalsIgnoreCase("")  || (profileBean.getEmailID().equalsIgnoreCase(null)) || profileBean.getEmailID().equalsIgnoreCase("") ||  (profileBean.getFirstName().equalsIgnoreCase(null)) || profileBean.getFirstName().equalsIgnoreCase("") || (profileBean.getGender().equalsIgnoreCase(null)) || profileBean.getGender().equalsIgnoreCase("") || (profileBean.getLastName().equalsIgnoreCase(null)) || profileBean.getLastName().equalsIgnoreCase("")|| (profileBean.getLocation().equalsIgnoreCase(null)) || profileBean.getLocation().equalsIgnoreCase("") || (profileBean.getMobileNo().equalsIgnoreCase(null)) || profileBean.getMobileNo().equalsIgnoreCase("") || (profileBean.getPassword().equalsIgnoreCase(null)) || profileBean.getPassword().equalsIgnoreCase("") || (profileBean.getPincode().equalsIgnoreCase(null)) || profileBean.getPincode().equalsIgnoreCase("") || (profileBean.getState().equalsIgnoreCase(null)) || profileBean.getState().equalsIgnoreCase("")  || (profileBean.getStreet().equalsIgnoreCase(null)) || profileBean.getStreet().equalsIgnoreCase("")  || (profileBean.getDateOfBirth().equals(null)))
//{
//	return "FAIL";	
//}
//else
//{
//			Session session = sessionFactory.getCurrentSession();
//			SQLQuery query = session
//					.createSQLQuery("select OCS_SEQ_USERID.NEXTVAL from dual");
//			int seq = ((BigDecimal) query.uniqueResult()).intValue();
//			System.out.println(seq);
//			profileBean.setUserID(profileBean.getFirstName().toUpperCase()
//					.substring(0, 2)
//					+ seq);
//			session.save(profileBean);
//
//			CredentialsBean credentialsBean = new CredentialsBean();
//			credentialsBean.setUserID(profileBean.getUserID());
//			credentialsBean.setPassword(profileBean.getPassword());
//			credentialsBean.setLoginStatus(0);
//			credentialsBean.setUserType("P");
//			session.save(credentialsBean);
//			
//			ProfileImage profileImage = new ProfileImage();
//			profileImage.setProfileImg(profileBean.getProfileImage());
//			profileImage.setProfileImgName(profileBean.getProfileImgName());
//			profileImage.setUserID(profileBean.getFirstName().toUpperCase()
//					.substring(0, 2)
//					+ seq);
//			session.save(profileImage);
//
//		} 
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return "FAIL";
//		}
//		return profileBean.getUserID();
//
//	}

}
