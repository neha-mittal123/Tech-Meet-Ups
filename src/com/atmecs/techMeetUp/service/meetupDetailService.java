package com.atmecs.techMeetUp.service;

import org.springframework.context.annotation.ComponentScan;


import com.atmecs.techMeetUp.pojos.MeetupDetail;

@ComponentScan("com.atmecs.techMeetUp")
public interface meetupDetailService {

	public String addMeetUp(MeetupDetail meetupDetail);
}
