package com.ias.report.dominio;

public class ReportResponse {
	
	private double dayHours;
	private double nightHours;
	private double sundayHours;
	private double extraDayHours;
	private double extraNightHours;
	private double extraSundayHours;
	private String idTechnical;
	private String weekNumber;
	
	public ReportResponse() {}
	public double getDayHours() {
		return dayHours;
	}
	public void setDayHours(double dayHours) {
		this.dayHours = dayHours;
	}
	public double getNightHours() {
		return nightHours;
	}
	public void setNightHours(double nightHours) {
		this.nightHours = nightHours;
	}
	public double getSundayHours() {
		return sundayHours;
	}
	public void setSundayHours(double sundayHours) {
		this.sundayHours = sundayHours;
	}
	public double getExtraDayHours() {
		return extraDayHours;
	}
	public void setExtraDayHours(double extraDayHours) {
		this.extraDayHours = extraDayHours;
	}
	public double getExtraNightHours() {
		return extraNightHours;
	}
	public void setExtraNightHours(double extraNightHours) {
		this.extraNightHours = extraNightHours;
	}
	public double getExtraSundayHours() {
		return extraSundayHours;
	}
	public void setExtraSundayHours(double extraSundayHours) {
		this.extraSundayHours = extraSundayHours;
	}
	public String getIdTechnical() {
		return idTechnical;
	}
	public void setIdTechnical(String idTechnical) {
		this.idTechnical = idTechnical;
	}
	public String getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}
	

}
