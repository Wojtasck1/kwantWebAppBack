package kwant.carapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cars") 
public class Car {
	
	@Id
	@GeneratedValue
	private Long carId;
	
	@Column(name = "plates")
	private String plates;
	
	@Column(name = "overview" ,columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date overview;
	
	@Column(name = "insurance", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date insurance;
	
	@Column(name = "course")
	private String course; 

	@Column(name = "description")
	private String description; 
	
	@Column(name = "usersId")
	private String usersId;
	
	@OneToMany(targetEntity=Note.class, cascade=CascadeType.ALL,
			mappedBy = "noteId" )
	private List<Note> noteList = new ArrayList<Note>(); 
	
	public Car(){} 
	
	public Car(Long carId,Date overview,Date insurance, String course , String description, String userId){
		
		this.carId = carId;
		this.overview = overview;
		this.insurance = insurance;
		this.course = course;
		this.description = description;
		this.usersId = userId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getPlates() {
		return plates;
	}

	public void setPlates(String plates) {
		this.plates = plates;
	}

	public Date getOverview() {
		return overview;
	}

	public void setOverview(Date overview) {
		this.overview = overview;
	}

	public Date getInsurance() {
		return insurance;
	}
 
	public void setInsurance(Date insurance) {
		this.insurance = insurance;
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

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	
	public List<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}
}
