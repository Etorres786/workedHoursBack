package com.ias.report.dominio.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ias.report.dominio.ReportRequest;
import com.ias.report.dominio.ReportResponse;
import com.ias.report.infraestructura.persistencia.entidad.ReportEntity;
import com.ias.report.infraestructura.persistencia.repositorio.ReportRepository;

@Service
public class ServiceReport {

	@Autowired
	private ReportRepository studentRepository;

	public ReportRequest saveReport(ReportRequest report) {
		try {
			for (int i = 0; i < report.getWorkedDays().size(); i++) {
				ReportEntity reportEntity = new ReportEntity();
				reportEntity.setIdReport(report.getIdReport());
				reportEntity.setIdTechnical(report.getIdTechnical());
				reportEntity.setWeekNumber(report.getWorkedDays().get(i).getWeekNumber());
				reportEntity.setDayHours(report.getWorkedDays().get(i).getDayHours());
				reportEntity.setNightHours(report.getWorkedDays().get(i).getNightHours());
				reportEntity.setSundayHours(report.getWorkedDays().get(i).getSundayHours());
				reportEntity.setStartDate(report.getWorkedDays().get(i).getStartDate());
				reportEntity.setEndDate(report.getWorkedDays().get(i).getEndDate());
				studentRepository.save((reportEntity));
			}
		} catch (Exception e) {
			
		}
		return report;
	}

	public ReportResponse getReport(String id, String week) {
		double totalHours = 0;
		double dayHours = 0;
		double nightHours = 0;
		double sundayHours = 0;
		double extraDayHours = 0;
		double extraNightHours = 0;
		double extraSundayHours = 0;

		ReportResponse reportResponse = new ReportResponse();
		List<ReportEntity> report = new ArrayList<ReportEntity>();
		report = studentRepository.findByIdTechnicalAndWeekNumberOrderByEndDate(id, week);

		if (report.isEmpty()) {
			reportResponse.setDayHours(dayHours);
			reportResponse.setNightHours(nightHours);
			reportResponse.setSundayHours(sundayHours);
			reportResponse.setExtraDayHours(extraDayHours);
			reportResponse.setExtraNightHours(extraNightHours);
			reportResponse.setExtraSundayHours(extraSundayHours);
			reportResponse.setIdTechnical("");
			reportResponse.setWeekNumber("");

		} else {
			for (int i = 0; i < report.size(); i++) {
				if (totalHours < 48.0) {
					if (report.get(i).getDayHours() + totalHours >= 48) {
						extraDayHours = diferencia(totalHours);
						totalHours = 48;
					} else {
						dayHours = dayHours + report.get(i).getDayHours();
						totalHours = totalHours + report.get(i).getDayHours();
					}

					if (report.get(i).getNightHours() + totalHours >= 48) {
						extraNightHours = diferencia(totalHours);
						totalHours = 48;
					} else {
						nightHours = nightHours + report.get(i).getNightHours();
						totalHours = totalHours + report.get(i).getNightHours();
					}

					if (report.get(i).getSundayHours() + totalHours >= 48) {
						extraSundayHours = diferencia(totalHours);
						totalHours = 48;
					} else {
						sundayHours = sundayHours + report.get(i).getSundayHours();
						totalHours = totalHours + report.get(i).getSundayHours();
					}
				} else {
					extraDayHours = extraDayHours + report.get(i).getDayHours();
					extraNightHours = extraNightHours + report.get(i).getNightHours();
					extraSundayHours = extraSundayHours + report.get(i).getSundayHours();
				}
			}
			reportResponse.setDayHours(dayHours);
			reportResponse.setNightHours(nightHours);
			reportResponse.setSundayHours(sundayHours);
			reportResponse.setExtraDayHours(extraDayHours);
			reportResponse.setExtraNightHours(extraNightHours);
			reportResponse.setExtraSundayHours(extraSundayHours);
			reportResponse.setIdTechnical(report.get(0).getIdTechnical());
			reportResponse.setWeekNumber(report.get(0).getWeekNumber());
		}

		return reportResponse;
	}

	public double diferencia(double totalHours) {
		double diferencia = 0;
		diferencia = 48 - totalHours;
		return diferencia;
	};

}
