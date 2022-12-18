package com.job.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, String>{

}
