package vn.edu.iuh.fit.utils;

import vn.edu.iuh.fit.dto.CompanyDto;
import vn.edu.iuh.fit.dto.JobDto;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Company;
import com.neovisionaries.i18n.CountryCode;


import java.util.List;
import java.util.stream.Collectors;

public class CompanyUtils {
    public static CompanyDto convertToDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(String.valueOf(company.getId()));
        companyDto.setCompanyName(company.getName());
        companyDto.setCompanyEmail(company.getEmail());
        companyDto.setCompanyPhone(company.getPhone());
        companyDto.setCompanyWebUrl(company.getWebURL());
        companyDto.setCompanyAbout(company.getAbout());
        Address address = company.getAddress();
        companyDto.setCompanyCity(address.getCity());
        companyDto.setCompanyZipcode(address.getZipcode());
        companyDto.setCompanyStreet(address.getStreet());
        companyDto.setCompanyAddressNumber(address.getNumber());
        companyDto.setCompanyCountry(address.getCountry().name());
        List<JobDto> jobDtos = company.getJobs().stream()
                .map(JobUtils::convertToDto)
                .collect(Collectors.toList());
        companyDto.setJobDtos(jobDtos);
        return companyDto;
    }
    public static Company convertToEntity(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getCompanyName());
        company.setEmail(companyDto.getCompanyEmail());
        company.setPhone(companyDto.getCompanyPhone());
        company.setWebURL(companyDto.getCompanyWebUrl());
        company.setAbout(companyDto.getCompanyAbout());
        Address address = new Address();
        address.setCity(companyDto.getCompanyCity());
        address.setZipcode(companyDto.getCompanyZipcode());
        address.setStreet(companyDto.getCompanyStreet());
        address.setNumber(companyDto.getCompanyAddressNumber());
        address.setCountry(CountryCode.valueOf(companyDto.getCompanyCountry()));
        company.setAddress(address);
        return company;
    }


}

