package com.dashboard.dao;

import java.util.ArrayList;

import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.StudentSkillBean;

public interface StudentDAO 
{
	public String addSchedule(String studentId,ScheduleBean sb);

	String addStudentSkill(String pId, String skillarray);
	ArrayList<String> viewStudentSkill(String pId);
	boolean calculateSkill(String pId);

}
