package com.dashboard.service;

import java.util.ArrayList;

import javax.json.JsonObject;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.AskBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.NotificationBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.TrainerBean;;

public interface Student {	
	String addStudentSkill(String pId,String skillarray);
	ArrayList<String> viewStudentSkill(String pId);
//<<<<<<< HEAD
	public String addEvent(String studentId, ScheduleBean sb);

//=======
	boolean calculateSkill(String pId);
	
//>>>>>>> branch 'master' of https://github.com/srinivasan-p/DashBoardE.git
	public ArrayList<AnnouncementBean> viewAnnouncements();
	public AnnouncementBean getAnnouncementBean(int anmtId);
	public CredentialBean getStudent(String studentId);
	public String addNotification(NotificationBean nb);
	public int countOfanmts(String studentId);
	public int countOfSameAnmts(int anmtId,String studentId);
	public ArrayList<AnnouncementBean> readAnnouncements(String studentId);

	
	public ArrayList<AnnouncementBean> readAnnouncementsSearch(String studentId,String subject);
	public ArrayList<AnnouncementBean> viewAnnouncementsSearch(String studentId,String subject);
	
	public	AskBean addCommentpost(AskBean askbean);
	public JsonObject addEvent(TrainerBean tb, int pagenumber);
	public ProfileBean getProfileBean(String id);
	public AskBean addPost(AskBean askbean);
	public AskBean addComment(AskBean askbean);
}
