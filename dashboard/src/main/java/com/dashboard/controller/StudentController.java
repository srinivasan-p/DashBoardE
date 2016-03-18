package com.dashboard.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.AskBean;
import com.dashboard.beans.NotificationBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.TrainerBean;
import com.dashboard.service.Student;
import com.dashboard.util.DBUtill;

@Controller
public class StudentController {

	@Autowired
	Student studentService;

	/////////////

	@RequestMapping(value = "/pic", method = RequestMethod.GET)
	public String pic(HttpServletRequest req) {
		System.out.println(req.getParameter("a"));
		ProfileBean pb = studentService.getProfileBean(req.getParameter("a"));
		System.out.println("something u have to seeeee");
		System.out.println(req.getParameter("a"));
		System.out.println("i m here");
		System.out.println(pb.getPhoto());
		req.setAttribute("bean", pb);
		return "disimage";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getvalues(Model model, HttpServletRequest request) {
		int pagenumber = 1;
		TrainerBean tb = new TrainerBean();
		if (request.getParameter("page") == null) {
			pagenumber = 1;
		} else {
			pagenumber = Integer.parseInt(request.getParameter("page"));
		}
		if (studentService.addEvent(tb, pagenumber) == null) {
			request.setAttribute("dataToDisplay", "No More Data To Display");
		}
		model.addAttribute("jsonobject", studentService.addEvent(tb, pagenumber));
		return "hu";
	}

	@RequestMapping(value = "/tostorepost", method = RequestMethod.GET)

	public @ResponseBody String toaddpostqwert(@RequestParam(value = "description") String description,
			HttpSession session) {
		System.out.println("im in controller");
		AskBean a = new AskBean();
		a.setDescription(description);

		System.out.println(a.getDescription());

		System.out.println("to dao");
		a.setStudentId((String) session.getAttribute("pId"));

		AskBean ask = studentService.addPost(a);
		System.out.println("i m in post Controller ");
		System.out.println(
				ask.getName() + "," + ask.getDescription() + "," + ask.getDateCreated() + "," + ask.getPostId());
		return ask.getName() + "," + ask.getDescription() + "," + ask.getDateCreated() + "," + ask.getPostId();
	}

	@RequestMapping(value = "/tostorecomment", method = RequestMethod.GET)

	public @ResponseBody String doValidate(@RequestParam(value = "description") String description,
			@RequestParam(value = "posttosend") String posttosend, @RequestParam(value = "type") String type,
			HttpSession session) {
		System.out.println("im in controller");
		AskBean a = new AskBean();
		a.setDescription(description);

		a.setPostId(Integer.parseInt(posttosend));
		System.out.println(a.getDescription());
		System.out.println(a.getPostId());
		System.out.println("to dao");
		a.setStudentId((String) session.getAttribute("pId"));
		// a.setName("for tym being");
		AskBean ask = null;
		System.out.println("type.......");
		System.out.println(Integer.parseInt(type));
		if (Integer.parseInt(type) == 0) {
			System.out.println(" i m in type 0");
			ask = studentService.addComment(a);
		} else {
			System.out.println(" i m in type 1");
			ask = studentService.addCommentpost(a);
		}

		System.out.println(ask.getName() + "," + ask.getDescription() + "," + ask.getDateCreated() + ","
				+ Integer.parseInt(posttosend));
		return ask.getName() + "," + ask.getDescription() + "," + ask.getDateCreated() + ","
				+ Integer.parseInt(posttosend);
	}

	////////////

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

	@RequestMapping(value = "/tocancelnotification", method = RequestMethod.POST)
	public @ResponseBody String tocancelnotification(HttpSession httpSession, Model model, HttpServletRequest request)
			throws Exception {
		String pId = (String) httpSession.getAttribute("pId");
		String id = request.getParameter("id");
		Connection conn = DBUtill.getDBConnection();
		PreparedStatement pre = conn.prepareStatement("delete from newdb.db_Conflict where Sno=?");
		pre.setString(1, id);
		pre.execute();
		return "";
	}
	// announcement

	@RequestMapping(value = "/viewannouncements", method = RequestMethod.GET)
	public String viewAnnouncements(Model model, HttpServletRequest request, HttpSession session) {
		// from session studentId
		System.out.println("in view announcements");
		// ArrayList<String> subjects=student.viewSubjects();

		String studentId = (String) session.getAttribute("pId");
		ArrayList<AnnouncementBean> announcementBeans = studentService.viewAnnouncements();
		if (announcementBeans == null || announcementBeans.size() == 0) {
			return "brdfail";
		} else {
			request.setAttribute("announcements1", announcementBeans);
			request.setAttribute("count", studentService.countOfanmts(studentId));
			request.setAttribute("readAnnouncements", studentService.readAnnouncements(studentId));
			// request.setAttribute("subjects",subjects);
			return "sample";

		}

	}

	@RequestMapping(value = "/addstatus", method = RequestMethod.POST)
	public @ResponseBody String addStatus(@RequestParam("anmtId") int anmtId, HttpSession session) {
		// from session studentId
		System.out.println("in stud ctlr inside add status*****");
		String studentId = (String) session.getAttribute("pId");
		int c = studentService.countOfSameAnmts(anmtId, studentId);
		if (c == 0) {
			NotificationBean notificationBean = new NotificationBean();
			notificationBean.setAnnouncementId(studentService.getAnnouncementBean(anmtId));
			notificationBean.setStudId(studentService.getStudent(studentId));
			notificationBean.setStatus(1);
			System.out.println("notbean added");

			return studentService.addNotification(notificationBean);
		}
		return "success";
	}

	@RequestMapping(value = "/searching", method = RequestMethod.POST)
	public @ResponseBody String addStatus1(@RequestParam("search") String search, HttpSession session) {
		String result = "";
		System.out.println("in searching&&&&&&&&&&&&&&&&&&&");
		result = result
				+ "<h4 style='margin-left:10px;'><a style='text-decoration:none;' href='viewannouncements.html'>Back to search<<</a></h4>";
		int i = 0;
		String studentId = (String) session.getAttribute("pId");
		ArrayList<AnnouncementBean> announcementBeans = studentService.viewAnnouncementsSearch(studentId, search);
		ArrayList<AnnouncementBean> readAnnouncements = studentService.readAnnouncementsSearch(studentId, search);
		if (announcementBeans == null) {
			result = result + "<h3 style='margin-left:10px;'>No results found for&nbsp" + search + "!!!!!</h3>";
			return result;
		}
		for (AnnouncementBean sub : announcementBeans) {

			int count2 = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMM,yyyy");
			String dt = sdf.format(sub.getAnnouncemntDt());
			System.out.println("Full**" + sub);

			for (AnnouncementBean a : readAnnouncements) {
				System.out.println("read**" + a);
				if (sub.getAnnouncemntId() == a.getAnnouncemntId()) {
					count2 = 1;
					result = result
							+ "<p><div style='margin-left:10px;'><span class='glyphicon glyphicon-calendar'></span><font color='black'>"
							+ dt + "</font></div> <h4 style='text-transform:capitalize;'><a id='a1' href='#!b" + i
							+ "'> &nbsp &nbsp &nbsp" + sub.getSubject()
							+ "</a></h4>&nbsp &nbsp &nbsp &nbsp<font color='#388E8E'>created by:" + sub.getUpdatedBy()
							+ "</font></p>";
					result = result + "<div class='box' id='b" + i + "'>&nbsp &nbsp &nbsp &nbsp" + sub.getMessage()
							+ "</div>";
					result = result + "<input type='hidden' id='anmtId" + i + "' value=" + sub.getAnnouncemntId() + ">";
					result = result + "<hr/>";
					i++;
					break;

				}
			}
			if (count2 == 0) {
				result = result
						+ "<p><div style='margin-left:10px;'><span class='glyphicon glyphicon-calendar'></span><font color='black'>"
						+ dt + "</font></div> <h4 style='text-transform:capitalize;'><a id='a2' href='#!b" + i
						+ "'> &nbsp &nbsp &nbsp" + sub.getSubject()
						+ "</a></h4>&nbsp &nbsp &nbsp &nbsp<font color='#388E8E'>created by:" + sub.getUpdatedBy()
						+ "</font></p>";
				result = result + "<div class='box' id='b" + i + "'>&nbsp &nbsp &nbsp &nbsp" + sub.getMessage()
						+ "</div>";
				result = result + "<input type='hidden' id='anmtId" + i + "' value=" + sub.getAnnouncemntId() + ">";
				result = result + "<hr/>";
				i++;
			}
		}
		return result;
	}

}
