package com.atmecs.techMeetUp.dao;




import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.ComponentScan;

import com.atmecs.techMeetUp.pojos.MeetupDetail;

import com.atmecs.techMeetUp.pojos.UserDetail;
@ComponentScan("com.atmecs.techMeetUp")
@Transactional
public interface userDetailDao {

	public String addUser(UserDetail userDetail);
	public String loginUser(String email,String password);
	public List<MeetupDetail> viewMeetUp();
	public  List<MeetupDetail> viewMeetUpByPresenter(String presenter);
	public String attend(String email,String title,Date date);

}
