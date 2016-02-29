package com.dashboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.util.Authentication;

@Controller
public class MainController {

	@RequestMapping(value = "/LoginForm", method = RequestMethod.GET)
	public String setValues(Model model) {
		CredentialBean registrationBean = new CredentialBean();
		model.addAttribute("index", registrationBean);
		System.out.println("i m here login page");
		return "LoginForm";
	}

	@Autowired
	Authentication authentication1;
	@Autowired
	SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@RequestMapping(value = "/LoginForm", method = RequestMethod.POST)
	public String addValues(HttpSession httpSession, @ModelAttribute("index") CredentialBean CredentialBean,
			Model model, HttpServletRequest request) {
		
		httpSession.setAttribute("cb", CredentialBean);
		String u = CredentialBean.getpId();
		String validate = authentication1.authenticate(CredentialBean);

		if (validate.equalsIgnoreCase("true")) {

			CredentialBean.setType(authentication1.authorize(u));

			if (authentication1.authorize(u).equalsIgnoreCase("a")) {
				authentication1.changeLoginStatus(CredentialBean, 1);
				System.out.println("admin");
				return "AdminPage";

			} else if (authentication1.authorize(u).equalsIgnoreCase("t")) {
				// sessionFactory.getCurrentSession().save(CredentialBean);
				System.out.println("patient");
				authentication1.changeLoginStatus(CredentialBean, 1);
				return "TrainerPage";

			} else if (authentication1.authorize(u).equals("s")) {
				CredentialBean.setStatus(1);
				// sessionFactory.getCurrentSession().save(CredentialBean);
				authentication1.changeLoginStatus(CredentialBean, 1);
				return "StudentPage";

			}
		}
		return "LoginForm";
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String getLogout(HttpSession httpSession, Model model) {
		
		CredentialBean CredentialBean = (CredentialBean) httpSession.getAttribute("cb");
		authentication1.changeLoginStatus(CredentialBean, 0);
		return "Logout";
	}

}
