package com.job.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.job.helper.JobHelper;
import com.job.model.Job;
import com.job.repo.JobRepo;



@Service
public class JobService {
	@Autowired
	private JobRepo jobRepo;
	
	public void save(MultipartFile file) {
		try {
			List<Job> products=JobHelper.convertExcelToListProduct(file.getInputStream());
			this.jobRepo.saveAll(products);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Job> getAllJobs(){
		return this.jobRepo.findAll();
	}
}
