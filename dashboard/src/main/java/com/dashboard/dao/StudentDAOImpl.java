package com.dashboard.dao;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.AskBean;
import com.dashboard.beans.AutoSeqPost;
import com.dashboard.beans.CommentBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.NotificationBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.SkillBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.beans.TrainerBean;
import com.dashboard.service.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	Student studentService;

	
	/*part*/

	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public ProfileBean getProfileBean(String id){
		Session session = sessionFactory.getCurrentSession();
		Query q1 = session.createQuery("from AskBean where postId="+Integer.parseInt(id));
		ArrayList<AskBean> al = new ArrayList<AskBean>();
		al = (ArrayList<AskBean>) q1.list();
		Query q = null;
		if(al.size()>0)
		{
	 q = session.createQuery("from ProfileBean where pId='"+al.get(0).getStudentId()+"'");}
		else
		{
			q = session.createQuery("from ProfileBean where pId='"+id+"'");
		}
	ArrayList<ProfileBean> apb = new ArrayList<ProfileBean>();
	apb = (ArrayList<ProfileBean>) q.list();
	//System.out.println(apb.get(0));
	
		
		
		return apb.get(0);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public JsonObject addEvent(TrainerBean tb,int pagenumber) {
	
		JsonArrayBuilder commentarray = Json.createArrayBuilder();
		Session s = sessionFactory.getCurrentSession();
		Query sql = s.createQuery("from AskBean where postId in (select DISTINCT postId from CommentBean where type =0 or type = 3)  order by dateCreated desc");
	//	System.out.println("I m in sorting and these are post id ");
	
		sql.setFirstResult((pagenumber-1)*5);
		sql.setMaxResults(5);
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy 'at' h:mm a");
		
		JsonArrayBuilder jab2 = Json.createArrayBuilder();
		ArrayList<AskBean> aList = (ArrayList<AskBean>) sql.list();
		//System.out.println(aList.get(0).getPostId());
		if(aList.size()==0)
		{
			return null;
		}
		for(int i=0;i<aList.size();i++){
			JsonArrayBuilder jab = Json.createArrayBuilder();
			JsonObjectBuilder job = Json.createObjectBuilder();
		AskBean a123 = (AskBean) aList.get(i);
		String dateDt = sdf.format(a123.getDateCreated());
		job.add("postdetails", Json.createArrayBuilder()
		.add(a123.getPostId())
		.add( a123.getName())
		.add(dateDt)
		.add( a123.getDescription()));
		sql = s.createQuery("from AskBean where postId in (select commentId from CommentBean where postId ='"+a123.getPostId()+"' and commentId !="+ 0+" and type = 0)");
		ArrayList<AskBean> aList1233 = (ArrayList<AskBean>) sql.list();
		for(AskBean ac: aList1233)
		{//System.out.println("imhere....");
		Query sql1 = s.createQuery("from AskBean where postId in (select commentId from CommentBean where postId ='"+ac.getPostId()+"' and commentId !="+ 0+" and type = 1)");
		ArrayList<AskBean> acp = (ArrayList<AskBean>) sql1.list();
	 dateDt = sdf.format(ac.getDateCreated());
		jab.add( ac.getPostId())
		.add( ac.getName())
		.add( dateDt)
		.add( ac.getDescription());

		for(AskBean acpA : acp )
		{
			System.out.println("asfjhbf............");
			JsonArrayBuilder jabcomm = Json.createArrayBuilder();
			 dateDt = sdf.format(acpA.getDateCreated());
			jabcomm
		.add( acpA.getPostId())
		.add( acpA.getName())
		.add(dateDt)
		.add( acpA.getDescription());
	
		
			jab.add(jabcomm);
		}
			
		}
	job.add("commentarray", jab);
	jab2.add(job);
	
		
		}
		JsonObjectBuilder job2 = Json.createObjectBuilder();
		job2.add("array", jab2);
		return  job2.build();
	
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public AskBean addPost(AskBean askbean) {
		System.out.println("i m in DAO post..........");
		int k = askbean.getPostId();
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ProfileBean where pId='"+askbean.getStudentId()+"'");
		ProfileBean pb = (ProfileBean) q.list().get(0);
	    askbean.setName(pb.getName());
		
		
		/*SQLQuery query = session.createSQLQuery( "select generatepost.nextval from dual" );
		int key = ((BigDecimal)query.uniqueResult()).intValue();*/
		SQLQuery 	sql = session.createSQLQuery("select seqToPost from newdb.AutoSeqPost order by seqToPost DESC");
		int v = (Integer)(sql.list()).get(0);v++;
		//System.out.println(".....postid......."+v);
		AutoSeqPost asp = new AutoSeqPost();
		asp.setSeqToPost(v);
		session.save(asp);
		askbean.setPostId(v);
		session.save(askbean);
	
		CommentBean cb =new CommentBean();
		cb.setCommentId(0);
		cb.setPostId(v);
	cb.setAuto(v);
	cb.setType(3);
	session.save(cb);
	
		return askbean;
	}




	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public AskBean addComment(AskBean askbean) {
int k = askbean.getPostId();
		System.out.println("addcomment");
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from ProfileBean where pId='"+askbean.getStudentId()+"'");
		ProfileBean pb = (ProfileBean) q.list().get(0);
	    askbean.setName(pb.getName());
		
		SQLQuery 	sql = session.createSQLQuery("select seqToPost from newdb.AutoSeqPost order by seqToPost DESC");
		int v = (Integer)(sql.list()).get(0);
		System.out.println("hvsyagvshjabhjscbauhbcsu");
		System.out.println(v);
		v++;
	
		
		
		System.out.println(".....postid......."+v);
		AutoSeqPost asp = new AutoSeqPost();
		asp.setSeqToPost(v);
		session.save(asp);
		askbean.setPostId(v);
		session.save(askbean);
		CommentBean cb =new CommentBean();
		cb.setCommentId(v);
		cb.setPostId(k);
	cb.setAuto(v);
	cb.setType(0);
	session.save(cb);
	
		return askbean;
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public AskBean addCommentpost(AskBean askbean) {
int k = askbean.getPostId();
		
		Session session = sessionFactory.getCurrentSession();
		
		
		Query q = session.createQuery("from ProfileBean where pId='"+askbean.getStudentId()+"'");
		ProfileBean pb = (ProfileBean) q.list().get(0);
	    askbean.setName(pb.getName());
		
		
		SQLQuery 	sql = session.createSQLQuery("select seqToPost from newdb.AutoSeqPost order by seqToPost DESC");
		int v = (Integer)(sql.list()).get(0);
		System.out.println("postidkkdjhskjhfuhekjf");
		System.out.println(v);
		v++;
		System.out.println(".....postid......."+v);
		AutoSeqPost asp = new AutoSeqPost();
		asp.setSeqToPost(v);
		session.save(asp);
		askbean.setPostId(v);
		session.save(askbean);
		CommentBean cb =new CommentBean();
		cb.setCommentId(v);
		cb.setPostId(k);
	cb.setAuto(v);
	cb.setType(1);
	session.save(cb);
	
		return askbean;
		
	}


	
	
	/*parrt*/
	
	
	
	
	////////
	

	
	
	public ArrayList<AnnouncementBean> viewAnnouncements() {
		
		ArrayList<AnnouncementBean> announcementBeans=new ArrayList<AnnouncementBean>();
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from AnnouncementBean order by announcemntDt desc");
		announcementBeans=(ArrayList<AnnouncementBean>) query.list();
		if(announcementBeans.size()>0){
		return announcementBeans;
		}
		else{
			System.out.println("list size is 0");
			return null;
		}
		
	}

	
	
	public AnnouncementBean getAnnouncementBean(int anmtId) {
		// TODO Auto-generated method stub
		if(anmtId!=0){
			
			ArrayList<AnnouncementBean> ab=new ArrayList<AnnouncementBean>();
			Session session = sessionFactory.getCurrentSession();
			//profileBean=(ProfileBean) session.get(ProfileBean.class,id);
			
			SQLQuery query=session.createSQLQuery("select * from db_Announcement where announcemntId=?");
			query.setInteger(0,anmtId);
			query.addEntity(AnnouncementBean.class);
			ab=(ArrayList<AnnouncementBean>) query.list();
			//System.out.println(profileBean);
			for(AnnouncementBean a:ab){
				System.out.println(a);
				return a;
			
			}
			
			}
			return null;
	}
	
	
	
	public CredentialBean getStudent(String studentId) {
		if(studentId!=null&&!studentId.equals("")){
		CredentialBean credentialBean=new CredentialBean();
		Session session = sessionFactory.getCurrentSession();
		credentialBean=(CredentialBean) session.get(CredentialBean.class,studentId);
		if(credentialBean==null){
			return null;
		}
		else{
			System.out.println(credentialBean.getpId());
			return credentialBean;
		}
		}
		return null;
	}

	
	
	public String addNotification(NotificationBean nb) {
		if(nb!=null){
		Session session = sessionFactory.getCurrentSession();
		int id=(Integer) session.save(nb);
		if(id!=0){
			return "success";
		}
		else{
			return "fail";
		}
		}
		return "fail";
	}


	
	public int countOfanmts(String studentId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("select count(a.announcemntId) from db_Announcement as a where not exists(select announcemntId from db_Notification as n where a.announcemntId=n.announcementId and n.pId=?)");
		query.setString(0,studentId);
		/*query.addEntity(AnnouncementBean.class);
		ArrayList<Integer> i=(ArrayList<Integer>) query.list();*/
		
		int count=((BigInteger) query.uniqueResult()).intValue();
		System.out.println(count);
		return count;
		

	}

	
	
	public int countOfSameAnmts(int anmtId, String studentId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("select count(announcementId) from db_Notification where announcementId=? and pId=?");
		query.setInteger(0, anmtId);
		query.setString(1, studentId);
		int count=((BigInteger) query.uniqueResult()).intValue();
		return count;
	}

	
	
	public ArrayList<AnnouncementBean> readAnnouncements(String studentId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("select * from db_Announcement as a where exists(select announcemntId from db_Notification as n where a.announcemntId=n.announcementId and n.pId=?) order by announcemntDt desc");
		query.setString(0, studentId);
		query.addEntity(AnnouncementBean.class);
		ArrayList<AnnouncementBean> ab=(ArrayList<AnnouncementBean>) query.list();
		return ab;
	}
	
	
	
	public ArrayList<AnnouncementBean> readAnnouncementsSearch(String studentId, String subject) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("select * from db_Announcement as a where exists(select announcemntId from db_Notification as n where a.announcemntId=n.announcementId and n.pId=?) and subject like '"+subject+"%' order by announcemntDt desc");
		query.setString(0, studentId);
		
		query.addEntity(AnnouncementBean.class);
		ArrayList<AnnouncementBean> ab=(ArrayList<AnnouncementBean>) query.list();
		return ab;
	}

	
	
	public ArrayList<AnnouncementBean> viewAnnouncementsSearch(String studentId, String subject) {
		ArrayList<AnnouncementBean> announcementBeans=new ArrayList<AnnouncementBean>();
		Session session = sessionFactory.getCurrentSession();
		System.out.println("!!!!!!in view announce");
		Query query=session.createQuery("from AnnouncementBean where subject like '"+subject+"%' order by announcemntDt desc");
		
		announcementBeans=(ArrayList<AnnouncementBean>) query.list();
		if(announcementBeans.size()>0){
		return announcementBeans;
		}
		else{
			System.out.println("list size is 0");
			return null;
		}
	}



	
	
	
	/////////
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	public String addSchedule(String studentId, ScheduleBean sb) {

		try {
			String pId = studentId;
			Session session = sessionFactory.getCurrentSession();
			CredentialBean cb = (CredentialBean) session.get(CredentialBean.class, pId);
			sb.setStudentId(cb);
			String scheduleId = (String) session.save(sb);

			if (scheduleId == null) {
				return "failure";
			} else {
				return "Success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";

	}

	public String addStudentSkill(String pId, String skillarray) {

		try {
			String[] skilla = skillarray.trim().split(",");
			for (int i = 0; i < skilla.length; i++) {
				StudentSkillBean ssb = new StudentSkillBean();
				Session session = sessionFactory.getCurrentSession();
				CredentialBean cd = (CredentialBean) session.get(CredentialBean.class, pId);
				ssb.setpId(cd);
				int skillId = Integer.parseInt(skilla[i].trim());
				SkillBean sb = (SkillBean) session.get(SkillBean.class, skillId);
				ssb.setSkillId(sb);
				ssb.setUpdatedBy(pId);
				ssb.setUpdatedOn(new Date());
				session.save(ssb);
				studentService.calculateSkill(pId);
			}
		} catch (Exception e) {
			System.out.println(e);
			return "Failure";
		}
		return "Success";

	}

	public ArrayList<String> viewStudentSkill(String pId) {
		Session session = sessionFactory.getCurrentSession();
		CredentialBean cd = (CredentialBean) session.get(CredentialBean.class, pId);
		Query query = session.createQuery(
				"select s.skillName from StudentSkillBean as ss INNER JOIN ss.skillId as s where ss.pId=?");
		query.setParameter(0, cd);
		@SuppressWarnings("unchecked")
		ArrayList<String> list = (ArrayList<String>) query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public boolean calculateSkill(String pId) {

		try {
			Session session = sessionFactory.getCurrentSession();
			CredentialBean cb = (CredentialBean) session.get(CredentialBean.class, pId);
			Query query = session.createQuery("from StudentSkillBean where pId=?");
			query.setParameter(0, cb);
			ArrayList<StudentSkillBean> ssblist = (ArrayList<StudentSkillBean>) query.list();
			int points = ssblist.size() * 10;

			CredentialBean cb1 = (CredentialBean) session.get(CredentialBean.class, pId);
			query = session.createQuery("from ProfileBean where pId=?");
			query.setParameter(0, cb1);
			ArrayList<ProfileBean> pblist = (ArrayList<ProfileBean>) query.list();
			if (!pblist.isEmpty()) {
				ProfileBean pb1 = (ProfileBean) pblist.get(0);
				pb1.setSkillPoints(points);
				Session sessin = sessionFactory.getCurrentSession();

				sessin.update(pb1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

}
