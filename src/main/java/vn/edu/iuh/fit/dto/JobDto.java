package vn.edu.iuh.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private long jobId;
    private String jobName;
    private String jobDescription;
    private List<JobSkillDto> jobSkillDtoList;
    private List<CompanyDto> companyDtoList;

    @Override
    public String toString() {
        return "JobDto{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobSkillDtoList=" + jobSkillDtoList +
                ", companyDtoList=" + companyDtoList +
                '}';
    }
}