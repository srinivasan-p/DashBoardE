package com.dashboard.util;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.CredentialBean;

@Service("authentication")
public class AuthenticationImpl implements Authentication {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String authenticate(CredentialBean user) 
	{
		Session session = sessionFactory.getCurrentSession();
try {
			
			if((user.equals(null))|| user.getPassword().equalsIgnoreCase(null) || user.getPassword().equalsIgnoreCase("") || user.getpId().equalsIgnoreCase(null) || user.getpId().equalsIgnoreCase("") || user.getpId().equalsIgnoreCase(null) || user.getpId().equalsIgnoreCase("")  )
			{
				return "register";	
			}
			else
			{
			String sql = "SELECT password FROM newdb.db_credential where pId=:use";
			SQLQuery query = session.createSQLQuery(sql);

			String u = user.getpId();

			query.setParameter("use", u);
			@SuppressWarnings("unchecked")
			ArrayList<String> type = (ArrayList<String>) query.list();
			if (type.get(0).equals(user.getPassword())) 
			{
				System.out.println("authenticated");
				sql = "SELECT status FROM newdb.db_credential where pId=:use";
				query = session.createSQLQuery(sql);
				query.setParameter("use", u);
				@SuppressWarnings("unchecked")
				ArrayList<Integer> s = (ArrayList<Integer>) query.list();
				if (s.get(0)==9999) 
				{
					return "NotApproved";
				}
				return "true";
			} 
			else 
			{
				return "false";
			}
			}

		} 
		catch (Exception e) 
		{
			System.out.println("in authentication error page");
			System.out.println(e);
			return "register";
		}
	}
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String authorize(String userId) {

		Session session = sessionFactory.getCurrentSession();

		try {
			if(userId.equalsIgnoreCase(null) || userId.equalsIgnoreCase("") )
			{
				return "INVALID";	
			}
			else
			{
			String sql = "select type from newdb.db_credential where pId=:use";
			SQLQuery query = session.createSQLQuery(sql);
			query.setParameter("use", userId);
			@SuppressWarnings("unchecked")
			ArrayList<String> type = (ArrayList<String>) query.list();
			System.out.println(type.get(0) +" is the USER TYPE");
			String use1 = type.get(0);
			return use1;
			}
		} catch (Exception e) {
			return "INVALID";
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean changeLoginStatus(CredentialBean user, int loginStatus) {

		
		try {
			
			if((user.equals(null))|| user.getPassword().equalsIgnoreCase(null) || user.getPassword().equalsIgnoreCase("") || user.getpId().equalsIgnoreCase(null) || user.getpId().equalsIgnoreCase("") || user.getpId().equalsIgnoreCase(null) || user.getpId().equalsIgnoreCase("")  ){
				return false;	
			}
			else{
			Session session = sessionFactory.getCurrentSession();
			CredentialBean cd = (CredentialBean) session.get(CredentialBean.class, user.getpId());
			cd.setStatus(loginStatus);
			session.update(cd);
			return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
