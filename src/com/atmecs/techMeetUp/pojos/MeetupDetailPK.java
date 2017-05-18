package com.atmecs.techMeetUp.pojos;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The primary key class for the meetup_details database table.
 * 
 */
@SuppressWarnings("serial")
@Embeddable

public class MeetupDetailPK implements Serializable{
	//default serial version id, required for serializable classes.
	
	private String title;
	private java.util.Date date;

	public MeetupDetailPK() {
	}

	
	
	public MeetupDetailPK(String title, Date date) {
		super();
		this.title = title;
		this.date = date;
	}



	@Override
	public String toString() {
		return "MeetupDetailPK [title=" + title + ", date=" + date + "]";
	}


@Column(name="title",length=10)
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.DATE)
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MeetupDetailPK)) {
			return false;
		}
		MeetupDetailPK castOther = (MeetupDetailPK)other;
		return 
			this.title.equals(castOther.title)
			&& this.date.equals(castOther.date);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.title.hashCode();
		hash = hash * prime + this.date.hashCode();
		
		return hash;
	}
}