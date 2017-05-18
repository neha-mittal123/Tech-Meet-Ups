package com.atmecs.techMeetUp.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.techMeetUp.dao.meetupDetailDao;

import com.atmecs.techMeetUp.pojos.MeetupDetail;
import com.atmecs.techMeetUp.service.meetupDetailService;
@Service(value="meetupDetailService")
@Transactional
public class meetupDetailServiceImpl implements meetupDetailService{
	
	@Autowired
	meetupDetailDao dao;

	@Override
	public String addMeetUp(MeetupDetail meetupDetail) {
		  
		System.out.println("in service add user");
		return dao.addMeetUp(meetupDetail) ;
	}

}
