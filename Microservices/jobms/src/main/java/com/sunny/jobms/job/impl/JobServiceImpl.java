package com.sunny.jobms.job.impl;

import com.sunny.jobms.job.Job;
import com.sunny.jobms.job.JobRepository;
import com.sunny.jobms.job.JobService;
import com.sunny.jobms.job.dto.JobDTO;
import com.sunny.jobms.job.external.Company;
import com.sunny.jobms.job.external.Review;
import com.sunny.jobms.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<JobDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
//        List<JobDTO> jobDTOS = new ArrayList<>();

        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private JobDTO convertToDTO(Job job) {
        Company company = restTemplate.getForObject(
                "http://COMPANY-SERVICE:8081/companies/" + job.getCompanyId(),
                Company.class);
        ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange(
                "http://REVIEW-SERVICE:8083/reviews?companyId=" + job.getCompanyId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>() {
        });

        List<Review> reviews = reviewResponse.getBody();
        return JobMapper.mapToJobWithCompanyDTO(job, company, reviews);
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDTO(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
