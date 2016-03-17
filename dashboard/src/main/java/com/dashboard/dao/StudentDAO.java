package com.dashboard.dao;

import java.util.ArrayList;

import javax.json.JsonObject;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.AskBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.NotificationBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.TrainerBean;

public interface StudentDAO 
{
	public String addSchedule(String studentId,ScheduleBean sb);

	String addStudentSkill(String pId, String skillarray);
	ArrayList<String> viewStudentSkill(String pId);
	boolean calculateSkill(String pId);
	public	AskBean addCommentpost(AskBean askbean);
	public JsonObject addEvent(TrainerBean tb, int pagenumber);
	public ProfileBean getProfileBean(String id);
	public AskBean addPost(AskBean askbean);
	public AskBean addComment(AskBean askbean);
	
	
	public ArrayList<AnnouncementBean> viewAnnouncements();
	public AnnouncementBean getAnnouncementBean(int anmtId);
	public CredentialBean getStudent(String studentId);
	public String addNotification(NotificationBean nb);
	public int countOfanmts(String studentId);
	public int countOfSameAnmts(int anmtId,String studentId);
	public ArrayList<AnnouncementBean> readAnnouncements(String studentId);

	public ArrayList<AnnouncementBean> readAnnouncementsSearch(String studentId,String subject);
	public ArrayList<AnnouncementBean> viewAnnouncementsSearch(String studentId,String subject);
}
