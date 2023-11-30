package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServices {
    private SkillRepository skillRepository;
    @Autowired

    public SkillServices(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAll(){
        return skillRepository.findAll();
    }
    public Optional<Skill> findById(long id){
        return skillRepository.findById(id);
    }
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }
}
