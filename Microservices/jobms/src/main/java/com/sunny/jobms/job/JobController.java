package com.sunny.jobms.job;

import com.sunny.jobms.job.dto.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobDTO>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully!", HttpStatus.CREATED);
    }

    @GetMapping("jobs/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        JobDTO jobDTO = jobService.getJobById(id);
        if (jobDTO != null)
            return new ResponseEntity<>(jobDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean delete = jobService.deleteJobById(id);
        if (delete)
            return ResponseEntity.ok("Job deleted successfully!");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job dataToUpdate) {
        boolean updated = jobService.updateJobById(id, dataToUpdate);
        if (updated) return ResponseEntity.ok("Job updated successfully!");
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
}
