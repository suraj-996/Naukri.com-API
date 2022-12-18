package com.job.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Job {
	@Id
	private String uniq_id;
	@Size(min = 1, max = 65555)
	private String timestamp;
	@Size(min = 1, max = 65555)
	private String job_title;
	@Size(min = 1, max = 65555)
	private String job_salary;
	@Size(min = 1, max = 65555)
	private String job_experience_required;
	@Size(min = 1, max = 65555)
	private String key_skills;
	@Size(min = 1, max = 65555)
	private String role_category;
	@Size(min = 1, max = 65555)
	private String location; 
	@Size(min = 1, max = 65555)
	private String functional_area;
	@Size(min = 1, max = 65555)
	private String industry;
	@Size(min = 1, max = 65555)
	private String role;

}
