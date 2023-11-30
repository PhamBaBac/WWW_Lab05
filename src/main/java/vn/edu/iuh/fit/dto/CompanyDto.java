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
public class CompanyDto {
    private String companyId;
    private String companyName;
    private String companyEmail;
    private String companyPhone;
    private String companyWebUrl;
    private String companyAbout;
    private String companyCity;
    private String companyZipcode;
    private String companyStreet;
    private String companyAddressNumber;
    private String companyCountry;
    private List<JobDto> jobDtos;

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyName='" + companyId + '\'' +
                "companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyWebUrl='" + companyWebUrl + '\'' +
                ", companyAbout='" + companyAbout + '\'' +
                ", companyCity='" + companyCity + '\'' +
                ", companyZipcode='" + companyZipcode + '\'' +
                ", companyStreet='" + companyStreet + '\'' +
                ", companyAddressNumber='" + companyAddressNumber + '\'' +
                ", companyCountry='" + companyCountry + '\'' +
                '}';
    }
}
