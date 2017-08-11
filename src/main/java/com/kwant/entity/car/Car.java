package com.kwant.entity.car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue
	@Column(name = "car_Id")
	private Long carId;

	@Column(name = "plates")
	private String plates;

	@Column(name = "overview", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date overview;

	@Column(name = "is_user_aver_of_overview_expiration")
	private boolean isUserAverOfOverviewExpiration;

	@Column(name = "insurance", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insurance;

	@Column(name = "is_user_aver_of_insurance_expiration")
	private boolean isUserAverOfInsuranceExpiration;

	@Column(name = "course")
	private Long course;

	@Column(name = "description")
	private String description;

	@Column(name = "users_Id")
	private Long usersId;

	@Column(name = "last_oil_change")
	private Long lastOilChange;

	@Column(name = "is_user_aver_of_oil_change")
	private boolean isUserAverOfOilChange;

	@OneToMany(targetEntity = CarNote.class, cascade = CascadeType.ALL, mappedBy = "noteId")
	private List<CarNote> noteList = new ArrayList<CarNote>();

	public Car() {
	}

	public Car(Long carId, Date overview, Date insurance, Long course, String description, Long userId) {

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

	public Long getCourse() {
		return course;
	}

	public void setCourse(Long course) {
		setUserAverOfInsuranceExpiration(false);
		setUserAverOfOilChange(false);
		setUserAverOfOverviewExpiration(false);
		this.course = course;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUsersId() {
		return usersId;
	}

	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}

	public List<CarNote> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<CarNote> noteList) {
		this.noteList = noteList;
	}

	public boolean isUserAverOfOverviewExpiration() {
		return isUserAverOfOverviewExpiration;
	}

	public void setUserAverOfOverviewExpiration(boolean isUserAverOfOverviewExpiration) {
		this.isUserAverOfOverviewExpiration = isUserAverOfOverviewExpiration;
	}

	public boolean isUserAverOfInsuranceExpiration() {
		return isUserAverOfInsuranceExpiration;
	}

	public void setUserAverOfInsuranceExpiration(boolean isUserAverOfInsuranceExpiration) {
		this.isUserAverOfInsuranceExpiration = isUserAverOfInsuranceExpiration;

	}

	public Long getLastOilChange() {
		return lastOilChange;
	}

	public void setLastOilChange(Long lastOilChange) {

		this.lastOilChange = lastOilChange;
	}

	public boolean isUserAverOfOilChange() {
		return isUserAverOfOilChange;
	}

	public void setUserAverOfOilChange(boolean isUserAverOfOilChange) {
		this.isUserAverOfOilChange = isUserAverOfOilChange;
	}
}