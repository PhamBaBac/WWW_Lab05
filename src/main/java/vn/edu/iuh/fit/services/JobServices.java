package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.repositories.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobServices {
    private JobRepository jobRepository;
    @Autowired

    public JobServices(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public Optional<Job> findById(long id){
        return jobRepository.findById(id);
    }
    public List<Job> getAll(){
        return jobRepository.findAll();
    }
    public Job createJob(Job job){
        return jobRepository.save(job);
    }
}
