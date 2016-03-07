package com.dashboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.beans.TrainerBean;
import com.dashboard.service.Trainer;

@Controller
public class TrainerController {
	
	@Autowired
	Trainer trainer;
	
	
	
	@RequestMapping(value="/completionStatus",method=RequestMethod.GET)
	public String addEvent(Model model,HttpServletRequest request,HttpSession session)
	{	
		
		return "Attendance";
	}

}
