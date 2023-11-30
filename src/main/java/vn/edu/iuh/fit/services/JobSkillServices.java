package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.JobSkillRepository;

import java.util.List;

@Service
public class JobSkillServices {
    @Autowired
    private JobSkillRepository jobSkillRepository;


    public JobSkillServices(JobSkillRepository jobSkillRepository) {
        this.jobSkillRepository = jobSkillRepository;
    }

    public List<JobSkill> getAll(){
        return jobSkillRepository.findAll();
    }
    public JobSkill save(JobSkill jobSkill) {
        return jobSkillRepository.save(jobSkill);
    }
}
