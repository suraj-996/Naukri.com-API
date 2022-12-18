package com.job.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.job.helper.JobHelper;
import com.job.model.Job;
import com.job.service.JobService;


@RestController
@CrossOrigin("*")
public class JobController {
	@Autowired
	private JobService jobService;
	
	
	@PostMapping("/jobs/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(JobHelper.checkExcelFormat(file)) {
			this.jobService.save(file);
			return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved to db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
	}
	
	@GetMapping("/jobs")
	public List<Job> getAllJobs(){
		return this.jobService.getAllJobs();
	}
}
