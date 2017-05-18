package com.atmecs.techMeetUp.pojos;


import javax.persistence.*;

import com.atmecs.techMeetUp.Handler.jsonTimeDeserializer;
import com.atmecs.techMeetUp.Handler.jsonTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the meetup_details database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="meetup_details")

public class MeetupDetail implements Serializable {
	
	private MeetupDetailPK id;
	private String description;
	private Timestamp endtime;
	private String guest;
	private String presenter;
	private Timestamp starttime;
	private List<AttendiesDetail> attendiesDetails;

	public MeetupDetail() {
	}


	@Override
	public String toString() {
		return "MeetupDetail [id=, description=" + description + ", endtime=" + endtime + ", guest=" + guest
				+ ", presenter=" + presenter + ", starttime=" + starttime + "]";
	}



	public MeetupDetail(MeetupDetailPK id) {
		super();
		this.id = id;
	}


	@EmbeddedId
	public MeetupDetailPK getId() {
		return this.id;
	}

	public void setId(MeetupDetailPK id) {
		this.id = id;
	}

@Column(length=20)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@JsonSerialize(using=jsonTimeSerializer.class)
	//@JsonDeserialize(using=jsonTimeDeserializer.class)
	
	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	

	//bi-directional many-to-one association to AttendiesDetail
		@OneToMany(mappedBy="meetupDetail", fetch=FetchType.EAGER ,cascade = CascadeType.ALL)
		public List<AttendiesDetail> getAttendiesDetails() {
			return this.attendiesDetails;
		}

		public void setAttendiesDetails(List<AttendiesDetail> attendiesDetails) {
			this.attendiesDetails = attendiesDetails;
		}

		public AttendiesDetail addAttendiesDetail(AttendiesDetail attendiesDetail) {
			getAttendiesDetails().add(attendiesDetail);
			attendiesDetail.setMeetupDetail(this);

			return attendiesDetail;
		}

		public AttendiesDetail removeAttendiesDetail(AttendiesDetail attendiesDetail) {
			getAttendiesDetails().remove(attendiesDetail);
			attendiesDetail.setMeetupDetail(null);

			return attendiesDetail;
		}

	@Column(length=10)
	public String getGuest() {
		return this.guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

@Column(length=10)
	public String getPresenter() {
		return this.presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}


	@JsonSerialize(using=jsonTimeSerializer.class)
	@JsonDeserialize(using=jsonTimeDeserializer.class)
	
	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

}