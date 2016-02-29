package com.dashboard.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;

//	@Override
//	public String addAilmentDetails(PatientBean patientBean) {
//		Session session = sessionFactory.getCurrentSession();
//		try {
//			SQLQuery query = session
//					.createSQLQuery("select OCS_SEQ_PATIENTID.NEXTVAL from dual");
//
//			int seq = ((BigDecimal) query.uniqueResult()).intValue();
//			patientBean.setPatientID(patientBean.getUserID().toUpperCase()
//					.substring(0, 2)
//					+ seq);
//			System.out.println(patientBean.getUserID() + " "
//					+ patientBean.getPatientID() + " " + seq);
//
//			query = session
//					.createSQLQuery("insert into OCS_TBL_PATIENT values (?,?,?,?,?,?)");
//			query.setString(0, patientBean.getPatientID());
//			query.setString(1, patientBean.getAilmentDetails());
//			query.setString(2, patientBean.getAilmentType());
//			query.setDate(3, new Date());
//			query.setString(4, patientBean.getDiagnosisHistory());
//			query.setString(5, patientBean.getUserID());
//			int res = query.executeUpdate();
//			if (res > 0) {
//				return "SUCCESS";
//			} else {
//				return "FAIL";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "FAIL";
//		}
//	}
//
//	@Override
//	public boolean modifyAilmentDetails(PatientBean patientBean) {
//		try {
//			System.out.println("hiiii dao");
//			Session session = sessionFactory.getCurrentSession();
//			SQLQuery query = session
//					.createSQLQuery("update OCS_TBL_PATIENT set USERID=?,AILMENTDETAILS=?,AILMENTTYPE=?,DIAGNOSISHISTORY=? where patientid=?");
//			query.setString(4, patientBean.getPatientID());
//			query.setString(1, patientBean.getAilmentDetails());
//			query.setString(2, patientBean.getAilmentType());
////			query.setDate(3, patientBean.getAppointmentDate());
//			query.setString(3, patientBean.getDiagnosisHistory());
//			query.setString(0, patientBean.getUserID());
//			int res = query.executeUpdate();
//			if (res > 0) {
//				return true;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//
//		}
//	}
//
//	@Override
//	public ArrayList<PatientBean> viewAilmentDetails(String patientID) {
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			Query query = session
//					.createSQLQuery("select * from OCS_TBL_PATIENT where patientID = ?");
//			query.setString(0, patientID);
//			List<Object[]> list = query.list();
//			ArrayList<PatientBean> a = new ArrayList<>();
//			for (Object[] object : list) {
//				PatientBean pb = new PatientBean();
//				pb.setPatientID((String) object[0]);
//				pb.setAilmentDetails((String) object[1]);
//				pb.setAilmentType((String) object[2]);
//				pb.setAppointmentDate((Date) object[3]);
//				pb.setDiagnosisHistory((String) object[4]);
//				pb.setUserID((String) object[5]);
//				a.add(pb);
//			}
//			if (a != null) {
//				return a;
//			}
//		} catch (Exception e) {
//			return null;
//		}
//		return null;
//	}
//
//	@Override
//	public ArrayList<DoctorBean> viewListOfDoctors(String type, Date date) {
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			
//			
//			
//			Query query = session
//					.createSQLQuery("select doctorID from OCS_TBL_SCHEDULES where availableDays like ? and doctorID IN (select doctorID from OCS_TBL_DOCTOR where specialization = ?) and DOCTORID NOT IN (select OCS_TBL_Leave.DOCTORID from OCS_TBL_Leave where LEAVEFROM<= ? AND LEAVETO>= ?) ");
//			String day = "%" + date.getDay() + "%";
//			query.setString(0, day);
//			query.setString(1, type);
//			query.setDate(2, date);
//			query.setDate(3, date);
//			List<String> list = query.list();
//			ArrayList<DoctorBean> a = new ArrayList<>();
//			for (String object : list) {
//				
//				query = session
//						.createSQLQuery("select count(OCS_TBL_APPOINTMENTS.APPOINTMENTID)from OCS_TBL_APPOINTMENTS where OCS_TBL_APPOINTMENTS.APPOINTMENTDATE= ? and doctorid=?");
//				query.setDate(0, date);
//				query.setString(1, object);
//				int count = ((BigDecimal) query.uniqueResult()).intValue();
//				if(count<8){
//					DoctorBean doctorBean = (DoctorBean) session.get(
//							DoctorBean.class, object);
//					a.add(doctorBean);
//				}
//			}
//
//			// select doctorID from OCS_TBL_SCHEDULES where availableDays like
//			// '%3%' and doctorID IN
//			// (select doctorID from OCS_TBL_DOCTOR where specialization =
//			// 'Heart') and doctorID not in (SELECT DOCTORID FROM
//			// OCS_TBL_APPOINTMENTS WHERE APPOINTMENTTIME <> '8')
//
//			// SELECT DOCTORID FROM OCS_TBL_APPOINTMENTS WHERE APPOINTMENTTIME
//			// <> '8' AND DOCTORID IN (select doctorID from OCS_TBL_SCHEDULES
//			// where availableDays like '%3%' and
//			// doctorID IN (select doctorID from OCS_TBL_DOCTOR where
//			// specialization = 'Heart'))
//			return a;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//
//	}
//
//	@Override
//	public String requestforAppointment(String doctorID, Date appointmentDate,
//			String userID, String specialization) {
//
//		Session session = sessionFactory.getCurrentSession();
//		SQLQuery query = session
//				.createSQLQuery("select OCS_SEQ_APPOINTMENTID.NEXTVAL from dual");
//		int seq = ((BigDecimal) query.uniqueResult()).intValue();
//		DateTime datetime = new DateTime(appointmentDate);
//		String month = Integer.toString(datetime.getMonthOfYear());
//		String day = Integer.toString(datetime.getDayOfMonth());
//		if (month.length() == 1) {
//			month = 0 + month;
//		}
//		if (day.length() == 1) {
//			day = 0 + day;
//		}
//		String finalSeq = month + day + seq;
//
//		query = session
//				.createSQLQuery("select PATIENTID from OCS_TBL_PATIENT where AILMENTTYPE=? and userid = ?");
//		query.setString(0, specialization);
//		query.setString(1, userID);
//		List<String> list = query.list();
//		if (!list.isEmpty()) {
//			String patientID = list.get(0);
//			query = session
//					.createSQLQuery("update OCS_TBL_PATIENT set APPOINTMENTDATE=? where PATIENTID=? ");
//			// SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
//			// Date appointmentDate = sim.parse(date);
//			query.setDate(0, appointmentDate);
//			query.setString(1, patientID);
//			query.executeUpdate();
//
//			// select * from OCS_TBL_Doctor where OCS_TBL_Doctor.DOCTORID NOT IN
//			// (select OCS_TBL_Leave.DOCTORID from OCS_TBL_Leave where
//			// LEAVEFROM<= '18-jan-2016' AND LEAVETO>= '18-jan-2016') and
//			// doctorid=2
//			query = session
//					.createSQLQuery("select * from OCS_TBL_Doctor where OCS_TBL_Doctor.DOCTORID NOT IN (select OCS_TBL_Leave.DOCTORID from OCS_TBL_Leave where LEAVEFROM<= ? AND LEAVETO>= ?) and doctorid=?");
//			query.setDate(0, appointmentDate);
//			query.setDate(1, appointmentDate);
//			query.setString(2, doctorID);
//			List<String> list2 = query.list();
//			if (!list2.isEmpty()) {
//				query = session
//						.createSQLQuery("select count(OCS_TBL_APPOINTMENTS.APPOINTMENTID)from OCS_TBL_APPOINTMENTS where OCS_TBL_APPOINTMENTS.APPOINTMENTDATE= ? and doctorid=?");
//				query.setDate(0, appointmentDate);
//				query.setString(1, doctorID);
//				int count = ((BigDecimal) query.uniqueResult()).intValue();
//
//				if (count > 0 && count < 8) {
//					System.out.println("count is " + count);
//					query = session
//							.createSQLQuery("insert into OCS_TBL_APPOINTMENTS values(?,?,?,?,?)");
//					query.setString(0, finalSeq);
//					query.setDate(1, appointmentDate);
//					query.setString(2, Integer.toString(count + 1));
//					query.setString(3, doctorID);
//					query.setString(4, patientID);
//					query.executeUpdate();
//
//				} else if (count == 0) {
//					System.out.println("count is 0");
//					query = session
//							.createSQLQuery("insert into OCS_TBL_APPOINTMENTS values(?,?,?,?,?)");
//					query.setString(0, finalSeq);
//					query.setDate(1, appointmentDate);
//					query.setString(2, "1");
//					query.setString(3, doctorID);
//					query.setString(4, patientID);
//					query.executeUpdate();
//				}
//
//			} else {
//				System.out.println("Sorry the doctor is on leave");
//			}
//
//		} else {
//			System.out.println("First add ailment details and come back again");
//			return "addailment";
//		}
//
//		return "CONFIRMED";
//	}
//
//	@Override
//	public Map<AppointmentBean, PatientBean> viewAppointmentDetails(String patientID, Date date) {
//		Map< AppointmentBean,PatientBean> map = new HashMap< AppointmentBean,PatientBean>();
//	 Session session = sessionFactory.getCurrentSession();
//	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//	 SQLQuery sqlQuery = session.createSQLQuery("select OCS_TBL_patient.PATIENTID,OCS_TBL_patient.AILMENTDETAILS,OCS_TBL_patient.AILMENTTYPE,OCS_TBL_patient.APPOINTMENTDATE,OCS_TBL_patient.DIAGNOSISHISTORY,OCS_TBL_patient.USERID,ocs_tbl_appointments.APPOINTMENTID,ocs_tbl_appointments.APPOINTMENTTIME,ocs_tbl_appointments.DOCTORID from OCS_TBL_patient inner join ocs_tbl_appointments on OCS_TBL_patient.PATIENTID=ocs_tbl_appointments.PATIENTID where ocs_tbl_appointments.APPOINTMENTDATE= :dat AND ocs_tbl_appointments.patientid= :patid ");
//	 sqlQuery.setParameter("dat", sqlDate);
//	 sqlQuery.setParameter("patid", patientID);
//	 @SuppressWarnings("unchecked")
//	List<Object[]> list = sqlQuery.list();
//	 for (Object[] object : list) 
//		{
//			PatientBean pb = new PatientBean();
//			AppointmentBean ab = new AppointmentBean();
//			pb.setPatientID((String)object[0]);
//			pb.setAilmentDetails((String)object[1]);
//			pb.setAilmentType((String)object[2]);
//			pb.setAppointmentDate((Date)object[3]);
//			pb.setDiagnosisHistory((String)object[4]);
//			pb.setUserID((String)object[5]);
//			java.sql.Date sqldateforapp= new java.sql.Date(((Date)object[3]).getTime());
//			ab.setAppointmentDate(sqldateforapp);
//			ab.setAppointmentTime((String)object[7]);
//			ab.setDoctorID((String)object[8]);
//			ab.setPatientID((String)object[0]);
//			ab.setAppointmentID((String)object[6]);
////			pb.setPatientID((String)object[0]);
////			pb.setDiagnosisHistory((String)object[4]);
////			pb.setAppointmentDate((Date)object[3]);
//			map.put(ab,pb);
//		}
//		return map;
//	}

}
