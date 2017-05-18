package com.atmecs.techMeetUp.daoImpl;






import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.atmecs.techMeetUp.dao.userDetailDao;
import com.atmecs.techMeetUp.pojos.AttendiesDetail;
import com.atmecs.techMeetUp.pojos.MeetupDetail;
import com.atmecs.techMeetUp.pojos.MeetupDetailPK;
import com.atmecs.techMeetUp.pojos.UserDetail;




@Repository(value="userDetailDao")
public class userDetailDaoImpl implements userDetailDao{

	@Autowired
	
	SessionFactory sf;
	@Override
	public String addUser(UserDetail userDetail) {
		Session session=sf.getCurrentSession();
		System.out.println("bfr");
		Transaction tx=session.beginTransaction();
		session.save(userDetail);
		System.out.println("aftr");
		tx.commit();
		System.out.println("user added");
		return "successfull";
	}

	public String loginUser(String email,String password){
		
		Session session=sf.getCurrentSession();
		System.out.println("bfr");
		Transaction tx=session.beginTransaction();
		
		Query result=session.createQuery("from UserDetail u where u.email='"+email+"'");
		System.out.println(result);
		@SuppressWarnings("unchecked")
		List<UserDetail> user=result.list();
		System.out.println("user:"+user);
	int res=0;
	System.out.println("Size of user list"+user.size());
	for(UserDetail u :user)
	{
		System.out.println(u.getCompanyName());
	}
	if(user.size()==0)
	{
		res=0;
	}
	else
	{
		for(int i=0;i<user.size();i++)
		{
			System.out.println("inside for loop");
			String dbuserName=user.get(i).getEmail();
			String dbpassword=user.get(i).getPassword();
	
			if(dbuserName.equalsIgnoreCase("admin@atmecs.com")&&dbpassword.equalsIgnoreCase("admin"))
			{
				res=1;
			System.out.println(res);
			}
			else
			{
				
				if(dbuserName.equals(email)&&dbpassword.equals(password))
				{
					res=2;
					System.out.println("the result is:"+res);
				}
				
				
			}
		}
	}
	
		tx.commit();
		//System.out.println("Value of number of result"+res);
		if(res==1)
		{
		    return "admin login successfull ";
		}
		else if(res==2){
			return "user login successfull";
		}
		else
			return "unsuccessfull";
		
	}
	
	@SuppressWarnings("unchecked")
	public List<MeetupDetail> viewMeetUp(){
		
		Session session=sf.getCurrentSession();
		System.out.println("bfr");
		Transaction tx=session.beginTransaction();
		List<MeetupDetail> list=session.createCriteria(MeetupDetail.class).list();
		System.out.println("aftr");
		System.out.println(list);
		System.out.println("user added");
		tx.commit();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public  List<MeetupDetail> viewMeetUpByPresenter(String presenter){
		
		Session session=sf.getCurrentSession();
		System.out.println("bfr");
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(MeetupDetail.class);
		cr.add(Restrictions.eq("presenter", presenter));
		List<MeetupDetail> list=cr.list();
		System.out.println("aftr");
		System.out.println(list);
		tx.commit();
		return list;
	}

	@Override
	public String attend(String email,String title,Date date) {
		Session session=sf.getCurrentSession();
		System.out.println("bfr");
		Transaction tx=session.beginTransaction();
		UserDetail us=new UserDetail(email);
		MeetupDetailPK mp=new MeetupDetailPK(title,date);
		MeetupDetail ms=new MeetupDetail(mp);
		AttendiesDetail attendiesDetail=new AttendiesDetail(us,ms);
		session.save(attendiesDetail);
		System.out.println("attendiesDetail");
		tx.commit();
		return "added successfully";
	}
}

