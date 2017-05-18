package com.atmecs.techMeetUp.service;




import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;


import com.atmecs.techMeetUp.pojos.MeetupDetail;

import com.atmecs.techMeetUp.pojos.UserDetail;
@ComponentScan("com.atmecs.techMeetUp")

public interface userDetailService {

	public String addUser(UserDetail userDetail);
	public String loginUser(String email,String password);
	public List<MeetupDetail> viewMeetUp();
	public  List<MeetupDetail> viewMeetUpByPresenter(String presenter);
	public String attend(String email,String title,Date date);
}
