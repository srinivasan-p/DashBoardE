package com.dashboard.service;

import java.util.ArrayList;

import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.StudentSkillBean;;

public interface Student {	
	String addStudentSkill(String pId,String skillarray);
	ArrayList<String> viewStudentSkill(String pId);
//<<<<<<< HEAD
	public String addEvent(String studentId, ScheduleBean sb);

//=======
	boolean calculateSkill(String pId);
	
//>>>>>>> branch 'master' of https://github.com/srinivasan-p/DashBoardE.git
	
}
