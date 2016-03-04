package com.dashboard.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.service.Student;
import com.dashboard.util.Authentication;
import com.dashboard.util.User;

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
	@Autowired
	Student studentService;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@RequestMapping(value = "/LoginForm", method = RequestMethod.POST)
	public String addValues(HttpSession httpSession, @ModelAttribute("index") CredentialBean CredentialBean,
			Model model, HttpServletRequest request) {

		String u = CredentialBean.getpId();
		String validate = authentication1.authenticate(CredentialBean);

		if (validate.equalsIgnoreCase("true")) {
			studentService.calculateSkill(u);
			CredentialBean.setType(authentication1.authorize(u));

			httpSession.setAttribute("cb", CredentialBean);
			httpSession.setAttribute("pId", u);

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
		} else if (validate.equalsIgnoreCase("NotApproved")) {
			return "NotApproved";
		}
		return "LoginForm";
	}

	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String getLogout(HttpSession httpSession, Model model) {

		CredentialBean CredentialBean = (CredentialBean) httpSession.getAttribute("cb");
		authentication1.changeLoginStatus(CredentialBean, 0);
		return "Logout";
	}

	@Autowired
	User user;

	@RequestMapping(value = "/RegistrationForm", method = RequestMethod.GET)
	public String setReg(Model model) {
		com.dashboard.beans.ProfileBean registrationBean = new com.dashboard.beans.ProfileBean();
		model.addAttribute("RegistrationFormmodel", registrationBean);
		return "RegistrationForm";
	}

	@RequestMapping(value = "/RegistrationForm", method = RequestMethod.POST)
	public String addValues(@ModelAttribute("RegistrationFormmodel") @Valid ProfileBean pb, BindingResult bindingResult,
			HttpSession httpSession) throws IOException {
		if (bindingResult.hasErrors()) {

			FieldError error = bindingResult.getFieldError();
			System.out.println(error.getField());
			System.out.println("HAs Errors");
			return "RegistrationForm";
		}
		String stat = user.register(pb);
		httpSession.setAttribute("reg_id", pb.getpId());
		if (stat.equalsIgnoreCase("Success")) {
			return "Success";
		} else {
			return "Failure";
		}
	}

}
