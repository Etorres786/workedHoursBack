package com.ias.report.infraestructura.persistencia.builder;

import com.ias.report.dominio.ReportRequest;
import com.ias.report.infraestructura.persistencia.entidad.ReportEntity;

public class ReportBuilder {
    public static ReportEntity convertToEntity(ReportRequest report) {
    	ReportEntity reportEntity = new ReportEntity();
    	
        reportEntity.setIdReport(report.getIdReport());	
        reportEntity.setIdTechnical(report.getIdTechnical());
        reportEntity.setWeekNumber(report.getWorkedDays().get(0).getWeekNumber());
        reportEntity.setDayHours(report.getWorkedDays().get(0).getDayHours());
        reportEntity.setNightHours(report.getWorkedDays().get(0).getNightHours());
        reportEntity.setSundayHours(report.getWorkedDays().get(0).getSundayHours());
        
        return reportEntity;
    }
}
