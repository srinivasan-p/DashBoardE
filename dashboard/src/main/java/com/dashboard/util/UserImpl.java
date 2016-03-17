package com.dashboard.util;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.StudentSkillBean;

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
			profileBean.setSkillPoints(0);
			session.save(profileBean);
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
	}
//	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
//	public boolean calculateSkill(String pId) {
//		
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			CredentialBean cb =  (CredentialBean) session.get(CredentialBean.class, pId);
//			Query query =  session.createQuery("from StudentSkillBean where pId=?");
//			query.setParameter(0, cb);
//			ArrayList<StudentSkillBean> ssblist=(ArrayList<StudentSkillBean>) query.list();
//			int points = ssblist.size()*10;
//			System.out.println("The pOINT IS  ************************** points" + points);
//			query = session.createQuery("from ProfileBean where pId=?");
//			query.setParameter(0, cb);
//			ArrayList<ProfileBean> pblist=(ArrayList<ProfileBean>) query.list();
//			ProfileBean pb =(ProfileBean)pblist.get(0);
//			pb.setSkillPoints(points);
//			System.out.println(pb.toString());
//			session.update(pb);
////			System.out.println("Points Updated*****************"+  a);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}

}
