package com.ias.report.dominio;

import java.util.List;

public class ReportRequest {
	
	private String idTechnical;
	private String idReport;
	 
	public String getIdTechnical() {
		return idTechnical;
	}

	public void setIdTechnical(String idTechnical) {
		this.idTechnical = idTechnical;
	}

	public String getIdReport() {
		return idReport;
	}

	public void setIdReport(String idReport) {
		this.idReport = idReport;
	}

	public List<WorkedDays> getWorkedDays() {
		return workedDays;
	}

	public void setWorkedDays(List<WorkedDays> workedDays) {
		this.workedDays = workedDays;
	}

	private List<WorkedDays> workedDays;
}
