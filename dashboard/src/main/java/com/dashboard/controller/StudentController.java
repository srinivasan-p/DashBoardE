package com.dashboard.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.service.Student;

@Controller
public class StudentController {

	@Autowired
	Student studentService;

	@RequestMapping(value = "/SkillSelect", method = RequestMethod.GET)
	public String setSkill(Model model) {
		return "SkillSelect";
	}

	@RequestMapping(value = "/SkillSelect", method = RequestMethod.POST)
	public String addSkill(HttpSession httpSession, HttpServletRequest httpServletRequest) {

		String skillarray = httpServletRequest.getParameter("skillarray");
		String pId = (String) httpSession.getAttribute("pId");
		pId = pId.trim();
		String result = studentService.addStudentSkill(pId, skillarray);
		if (result.equalsIgnoreCase("Success")) {
			return "Success";
		} else {
			return "Failure";
		}
	}

	@RequestMapping(value = "/ViewSkill", method = RequestMethod.GET)
	public String viewSkill(HttpSession httpSession, Model model) {
		String pId = (String) httpSession.getAttribute("pId");
		ArrayList<String> list = studentService.viewStudentSkill(pId);
		model.addAttribute("skillList", list);
		return "ViewSkill";
	}

	@RequestMapping(value = "/CalculateSkill", method = RequestMethod.GET)
	public String calSkill(HttpSession httpSession, Model model) {
		String pId = (String) httpSession.getAttribute("pId");
		studentService.calculateSkill(pId);
		return "Success";
	}

}
