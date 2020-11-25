package com.ias.report.infraestructura.controllador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ias.report.dominio.ReportRequest;
import com.ias.report.dominio.ReportResponse;
import com.ias.report.dominio.servicio.ServiceReport;

@CrossOrigin
@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ServiceReport serviceReport;
	
    @PostMapping(path="/add")
    public  ResponseEntity<String> saveReport(@RequestBody ReportRequest report) {
    	serviceReport.saveReport(report);
    	return new ResponseEntity<String>(HttpStatus.OK);
    }
    
	@GetMapping("/{idTechnical}/{weekNumber}")
	public @ResponseBody ReportResponse getReport(@PathVariable(name = "idTechnical") String idTechnical, @PathVariable(name = "weekNumber") String weekNumber) {
		return serviceReport.getReport(idTechnical,weekNumber);
	}

}
