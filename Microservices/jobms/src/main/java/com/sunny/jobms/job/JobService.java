package com.sunny.jobms.job;

import com.sunny.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> findAll();
    void createJob(Job job);
    JobDTO getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJobById(Long id, Job job);
}
