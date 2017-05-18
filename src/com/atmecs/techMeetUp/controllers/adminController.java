package com.atmecs.techMeetUp.controllers;




import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.techMeetUp.pojos.MeetupDetail;

import com.atmecs.techMeetUp.service.meetupDetailService;


@RestController
public class adminController {
	
	@Autowired
	meetupDetailService service;
	
	@RequestMapping(value="/addMeetUp", method=RequestMethod.POST, headers = "Accept=application/json")
	public void addMeetUp(@RequestBody MeetupDetail meetupDetail)
	{
		System.out.println("Inside the add meet up admin controller");
		
		//Timestamp starttime=meetupDetail.getStarttime();
		Date dt=meetupDetail.getId().getDate();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		df.format(dt);
		System.out.println(df.format(dt));
		//myObjectMapper.setDateFormat(df);
		
		String res=service.addMeetUp(meetupDetail);
		System.out.println(res);
	}
	
	

}
