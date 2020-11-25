package com.ias.report.infraestructura.persistencia.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ias.report.infraestructura.persistencia.entidad.ReportEntity;

@Repository
public interface ReportRepository extends CrudRepository<ReportEntity, Integer>{
	
 List<ReportEntity> findByIdTechnicalAndWeekNumberOrderByEndDate(String idTechnical, String week);

}
