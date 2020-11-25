package com.ias.report.dominio.servicio.test;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import com.ias.report.dominio.ReportRequest;
import com.ias.report.dominio.ReportResponse;
import com.ias.report.dominio.WorkedDays;
import com.ias.report.dominio.servicio.ServiceReport;

public class ServicioReportTest {
	

	
	private final String idTechnical = "123";
	private final String idReport = "123";
	
	public ReportRequest ReportRequest() {
		ReportRequest report = new ReportRequest();
		WorkedDays workedDaysElement= new WorkedDays();
		List<WorkedDays> workedDays = new ArrayList<WorkedDays>();
		workedDays.add(workedDaysElement);
		workedDays.get(0).setDayHours(12);
		workedDays.get(0).setNightHours(2);
		workedDays.get(0).setSundayHours(1);
		workedDays.get(0).setWeekNumber("4");
		workedDays.get(0).setStartDate(new Date(0));
		workedDays.get(0).setEndDate(new Date(0));
		report.setIdReport(idReport);
		report.setIdTechnical(idTechnical);
		report.setWorkedDays(workedDays);
		
		return report;
	}
	
	public ReportResponse reportResponse() {
		ReportResponse reportResponse = new ReportResponse();
		reportResponse.setDayHours(8);
		reportResponse.setNightHours(0);
		reportResponse.setSundayHours(0);
		reportResponse.setExtraDayHours(9);
		reportResponse.setExtraNightHours(9);
		reportResponse.setExtraSundayHours(0);
		reportResponse.setWeekNumber("4");
		reportResponse.setIdTechnical("123");
		return reportResponse;
	}
	
	@Test
	public void saveReportTest() {
		ServiceReport service = new ServiceReport();
		ReportRequest report = new ReportRequest();
		report = service.saveReport(ReportRequest());
		assertNotNull(report);
		assertEquals(report.getIdTechnical(), idTechnical);
		assertEquals(report.getIdReport(), idReport);
	}
	
	@Test
	public void getReportTest() {
		 ServiceReport service = mock(ServiceReport.class);
		 ReportResponse getReport = new ReportResponse();
		 
		 when(service.getReport(idTechnical, "4")).thenReturn(reportResponse());
		 getReport = service.getReport("123","4");
		 assertNotNull(getReport);
		 assertEquals(idTechnical, "123");
	};
}
