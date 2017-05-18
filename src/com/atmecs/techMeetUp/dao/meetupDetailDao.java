package com.atmecs.techMeetUp.dao;

import javax.transaction.Transactional;

import org.springframework.context.annotation.ComponentScan;

import com.atmecs.techMeetUp.pojos.MeetupDetail;

@ComponentScan("com.atmecs.techMeetUp")
@Transactional
public interface meetupDetailDao {

	public String addMeetUp(MeetupDetail meetupDetail);
}
