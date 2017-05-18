package com.atmecs.techMeetUp.serviceImpl;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.atmecs.techMeetUp.dao.userDetailDao;
import com.atmecs.techMeetUp.pojos.MeetupDetail;

import com.atmecs.techMeetUp.pojos.UserDetail;
import com.atmecs.techMeetUp.service.userDetailService;

@Service(value="userDetailService")
@Transactional
public class userDetailServiceImpl implements userDetailService{

	@Autowired
	userDetailDao dao;
	@Override
	public String addUser(UserDetail userDetail) {
		System.out.println("in service add user");
		return dao.addUser(userDetail) ;
	}
	@Override
	public String loginUser(String email,String password){
		
		System.out.println("in service login user");
		return dao.loginUser(email,password) ;
	}
	@Override
	public List<MeetupDetail> viewMeetUp(){
		System.out.println("in service view meetup");
		List<MeetupDetail> meetupDetails= dao.viewMeetUp() ;
		return meetupDetails;
	}
	@Override
	public  List<MeetupDetail> viewMeetUpByPresenter(String presenter){
		System.out.println("in service view meetup by presenter");
		List<MeetupDetail> meetupDetails= dao.viewMeetUpByPresenter(presenter) ;
		return meetupDetails;
	}
	@Override
	public String attend(String email,String title,Date date) {
		
		System.out.println("in service attend ");
		return dao.attend(email,title,date) ;
	}
}
