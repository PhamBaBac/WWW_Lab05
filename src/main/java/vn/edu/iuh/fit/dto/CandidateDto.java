package vn.edu.iuh.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDto {
    private long candidateId;
    private String candidateName;
    private LocalDateTime candidateDob;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateCity;
    private String candidateZipcode;
    private String candidateStreet;
    private String candidateAddressNumber;
    private String candidateCountry;
    private List<CompanyDto> companyDtoList;
    private List<CandidateSkillDto> candidateSkillDtoList;


    @Override
    public String toString() {
        return "CandidateDto{" +
                "candidateId=" + candidateId +
                ", candidateName='" + candidateName + '\'' +
                ", candidateDob=" + candidateDob +
                ", candidatePhone='" + candidatePhone + '\'' +
                ", candidateEmail='" + candidateEmail + '\'' +
                ", candidateCity='" + candidateCity + '\'' +
                ", candidateZipcode='" + candidateZipcode + '\'' +
                ", candidateStreet='" + candidateStreet + '\'' +
                ", candidateAddressNumber='" + candidateAddressNumber + '\'' +
                ", candidateCountry='" + candidateCountry + '\'' +
                ", companyDtoList=" + companyDtoList +
                ", candidateSkillDtoList=" + candidateSkillDtoList +
                '}';
    }
}
