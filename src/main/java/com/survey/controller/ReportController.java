package com.survey.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.bean.Report;
import com.survey.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {
	@Autowired
	ReportService service;
	
	@PostMapping("/addReport")
	public String performAddReport(@RequestBody Report report) {
		service.addReport(report);
		return "Report added successfully";
	}
	
	@DeleteMapping("/deleteReport/{reportId}")
	public String performDeleteReport(@PathVariable("reportId") long reportId) throws Exception {
		service.deleteReport(reportId);
		return "Report Deleted Succefully";
	}
	
	@GetMapping("/getReportDetail/{reportId}")
	public Optional<Report> performGetReportById(@PathVariable("reportId") Long reportId) throws Exception{
		Optional<Report> report = service.getReportById(reportId);
		return report;
	}

	@GetMapping("/getAllReportDetails")
	public List<Report> performGetAllUsers() {
		List<Report> list = service.getAllReport();
		return list;
	}

}

