package vn.edu.iuh.fit.utils;

import vn.edu.iuh.fit.dto.JobDto;
import vn.edu.iuh.fit.dto.JobSkillDto;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.enums.SkillType;
import vn.edu.iuh.fit.models.Job;
import vn.edu.iuh.fit.models.JobSkill;
import vn.edu.iuh.fit.models.Skill;

import java.util.List;
import java.util.stream.Collectors;

public class JobUtils {
    public static JobDto convertToDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setJobName(job.getName().toUpperCase());
        jobDto.setJobDescription(job.getDescription());
        List<JobSkillDto> skillDtoList = job.getJobSkills().stream()
                .map(JobUtils::convertSkillToDto)
                .collect(Collectors.toList());
        jobDto.setJobSkillDtoList(skillDtoList);
        return jobDto;
    }

    public static JobSkillDto convertSkillToDto(JobSkill jobSkill) {
        JobSkillDto jobSkillDto = new JobSkillDto();
        jobSkillDto.setSkillName(jobSkill.getSkill().getSkillName());
        jobSkillDto.setSkillType(jobSkill.getSkill().getType().name());
        jobSkillDto.setSkillLevel(jobSkill.getSkillLevel().name().toLowerCase());
        return jobSkillDto;
    }
    public static Job convertToEntity(JobDto jobDto) {
        Job job = new Job();
        job.setName(jobDto.getJobName().toUpperCase());
        job.setDescription(jobDto.getJobDescription());
        List<JobSkill> jobSkills = jobDto.getJobSkillDtoList().stream()
                .map(JobUtils::convertDtoToSkill)
                .collect(Collectors.toList());
        job.setJobSkills(jobSkills);
        return job;
    }

    public static JobSkill convertDtoToSkill(JobSkillDto jobSkillDto) {
        JobSkill jobSkill = new JobSkill();
        Skill skill = new Skill();
        skill.setSkillName(jobSkillDto.getSkillName());
        skill.setType(SkillType.valueOf(jobSkillDto.getSkillType()));
        jobSkill.setSkill(skill);
        jobSkill.setSkillLevel(SkillLevel.valueOf(jobSkillDto.getSkillLevel().toUpperCase()));
        return jobSkill;
    }
}
