package vn.edu.iuh.fit.controllers;
import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.dto.JobDto;
import vn.edu.iuh.fit.enums.SkillLevel;
import vn.edu.iuh.fit.enums.SkillType;
import vn.edu.iuh.fit.models.*;
import vn.edu.iuh.fit.repositories.AddressRepository;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.services.CompanyService;
import vn.edu.iuh.fit.services.JobServices;
import vn.edu.iuh.fit.services.JobSkillServices;
import vn.edu.iuh.fit.utils.JobUtils;

import java.util.*;


@Controller
public class JobController {
    @Autowired
    private JobServices jobService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private JobSkillServices jobSkillServices;

    @GetMapping("/show-add-form")
    public String apply(Model model) {
        Candidate candidate = new Candidate();
        candidate.setAddress(new Address());
        model.addAttribute("candidate", candidate);
        model.addAttribute("address", candidate.getAddress());
        model.addAttribute("countries", CountryCode.values());
        model.addAttribute("skillTypes", Arrays.asList(SkillType.values()));
        model.addAttribute("skillLevels", Arrays.asList(SkillLevel.values()));
        return "job/applyJob";

    }
    @PostMapping("/candidates/add")
    public String addCandidate(
            @ModelAttribute("candidate") Candidate candidate,
            @ModelAttribute("address") Address address) {
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/companies/{id}/job")
    public String showAddJobForm(@PathVariable("id")long id, Model model){
        JobDto jobDto = new JobDto();
        model.addAttribute("companyId", id);
        model.addAttribute("jobDto", jobDto);
        model.addAttribute("skillTypes", Arrays.asList(SkillType.values()));
        model.addAttribute("skillLevels", Arrays.asList(SkillLevel.values()));
        return "job/add";
    }

    @PostMapping("/job/add")
    public String addJob(@ModelAttribute("jobDto") JobDto jobDto,
                         @RequestParam(name = "companyId") String companyId) {
        Optional<Company> companyOptional = companyService.findById(Long.parseLong(companyId));
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            Job job = JobUtils.convertToEntity(jobDto);
            job.setCompany(company);
            jobService.createJob(job);
            return "redirect:/company/" + companyId;
        } else {
            return "error";
        }
    }
}
