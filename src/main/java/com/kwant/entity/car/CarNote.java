package com.kwant.entity.car;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "carnotes")
public class CarNote {
	
	@Id
	@GeneratedValue
	@Column(name = "note_Id")
	private Long noteId; 

	@Column(name = "car_Id")
	private Long carId; 
	
	@Column(name = "course")
	private String course;
	 
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	private Car car;
	
	@Column(name = "createdate" ,columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	
	public CarNote(){};

	public Long getNoteId() { 
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedate() {
		return createdate;
	} 

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
}