package vn.edu.iuh.fit.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.dto.CandidateDto;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.repositories.AddressRepository;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.services.CandidateServices;
import vn.edu.iuh.fit.utils.CandidateUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateServices candidateServices;
    @Autowired
    private AddressRepository addressRepository;
    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/list_no_paging";
    }

    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateServices.findAll(currentPage - 1,
                pageSize, "id", "asc");

        model.addAttribute("candidatePage", candidatePage);

        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/list";
    }

    @GetMapping("/show-edit-form/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Optional<Candidate> opt = candidateRepository.findById(id);
        if(opt.isPresent()) {
            Candidate candidate = opt.get();
            model.addAttribute("candidate", candidate);
            model.addAttribute("address", candidate.getAddress());
            model.addAttribute("countries", CountryCode.values());
            return "/candidates/update";
        } else {
             return "error";
        }
    }
    @PostMapping("/candidates/update")
    public String update(
            @ModelAttribute("candidate") Candidate candidate,
            @ModelAttribute("address") Address address) {
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }
    @GetMapping("candidateDetail/{candidateId}")
    public String showCandidateDetail(@PathVariable("candidateId") long candidateId, Model model) {
        Optional<Candidate> candidateOptional = candidateServices.findById(candidateId);
        if (candidateOptional.isPresent()) {
            Candidate candidate = candidateOptional.get();

            CandidateDto candidateDto = CandidateUtils.convertToDto(candidate);
            model.addAttribute("candidate", candidateDto);
            return "candidates/candidateDetail";
        } else {
            return "error";
        }
    }

}
