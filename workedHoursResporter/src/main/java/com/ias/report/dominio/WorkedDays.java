package com.ias.report.dominio;

import java.sql.Date;

public class WorkedDays{
	private float dayHours;
	private float nightHours;
	private float sundayHours;
	private String weekNumber;
	private Date startDate;
	private Date endDate;
	


	public WorkedDays(float dayHours, float nightHours, float sundayHours, String weekNumber, Date startDate,
			Date endDate) {
		super();
		this.dayHours = dayHours;
		this.nightHours = nightHours;
		this.sundayHours = sundayHours;
		this.weekNumber = weekNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public WorkedDays () {};


	public float getDayHours() {
		return dayHours;
	}
	public void setDayHours(float dayHours) {
		this.dayHours = dayHours;
	}
	public float getNightHours() {
		return nightHours;
	}
	public void setNightHours(float nightHours) {
		this.nightHours = nightHours;
	}
	public float getSundayHours() {
		return sundayHours;
	}
	public void setSundayHours(float sundayHours) {
		this.sundayHours = sundayHours;
	}
	public String getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}

}
