package com.aniket.findjob.job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// @RequestMapping("/jobs")
// we can remove "/jobs" url part from everywhere in code and
// in future it is easy for us to change at one place only
// it works at both class level(here) or method level(in PUT)
@RestController
public class JobController {
    private final JobService jobService;      // remove final if error comes

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    //@PostMapping("/jobs")
    @RequestMapping(value = "/jobs" , method = RequestMethod.POST)
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted){
            return new ResponseEntity<>("Job deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job does not exist",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public  ResponseEntity<String> updateJob(@PathVariable Long id , @RequestBody Job updatedJob){
        boolean updated = jobService.updateJobById(id , updatedJob);
        if(updated){
            return new ResponseEntity<>("Job Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job does not exist",HttpStatus.NOT_FOUND);
    }

}
