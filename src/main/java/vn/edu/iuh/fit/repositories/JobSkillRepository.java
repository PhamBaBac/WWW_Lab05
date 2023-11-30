package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.models.Skill;

public interface JobSkillRepository extends JpaRepository<JobSkill, Skill> {
}