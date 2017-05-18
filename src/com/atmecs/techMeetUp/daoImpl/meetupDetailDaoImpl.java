package com.atmecs.techMeetUp.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atmecs.techMeetUp.dao.meetupDetailDao;
import com.atmecs.techMeetUp.pojos.MeetupDetail;
@Repository(value="meetupDetailDao")

public class meetupDetailDaoImpl implements meetupDetailDao{

@Autowired
	
	SessionFactory sf;
	@Override
	public String addMeetUp(MeetupDetail meetupDetail) {
		Session session=sf.getCurrentSession();
		System.out.println("bfr");
		Transaction tx=session.beginTransaction();
		//MeetupDetail meetupDetail2=(MeetupDetail) 
				session.save(meetupDetail);
		//meetupDetail2.getId().setDate(date);
		//meetupDetail2.getId().setTitle(title);
		System.out.println("aftr");
		tx.commit();
		System.out.println("meetup added");
		return "successfull";
		
	
		
	}

}
