package vn.edu.iuh.fit.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.dto.CompanyDto;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Company;
import vn.edu.iuh.fit.services.AddressService;
import vn.edu.iuh.fit.services.CompanyService;
import vn.edu.iuh.fit.utils.CompanyUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class CompanyControlller {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AddressService addressService;
    @GetMapping("/companies")
    public String getCompanies(Model model){
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "company/company";
    }

    @GetMapping("/company/{id}")
    public String getDetailCompany(@PathVariable("id") long id, Model model) {
        Optional<Company> companyOptional = companyService.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            CompanyDto companyDto = CompanyUtils.convertToDto(company);
            model.addAttribute("company", companyDto);
            return "company/companyDetail";
        } else {
            return "redirect:/error";
        }
    }
    @GetMapping("/company/add")
    public String showAddCompanyForm(Model model) {
        model.addAttribute("companyDto", new CompanyDto());
        model.addAttribute("countryCode", Arrays.asList(CountryCode.values()));
        return "company/add";
    }
    @PostMapping("/company/add")
    public String addCompany(@ModelAttribute("companyDto") CompanyDto companyDto) {
        Company company = CompanyUtils.convertToEntity(companyDto);
        Address address = company.getAddress();
        addressService.updateAddress(address);
        company.setAddress(address);
        companyService.updateCompany(company);
        return "redirect:/companies";
    }

}
