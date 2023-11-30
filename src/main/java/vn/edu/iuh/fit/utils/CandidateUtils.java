package vn.edu.iuh.fit.utils;

import vn.edu.iuh.fit.dto.CandidateDto;
import vn.edu.iuh.fit.dto.CandidateSkillDto;
import vn.edu.iuh.fit.models.Address;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.CandidateSkill;

import java.util.List;
import java.util.stream.Collectors;

public class CandidateUtils {
    public static CandidateDto convertToDto(Candidate candidate) {
        CandidateDto candidateDto = new CandidateDto();
        candidateDto.setCandidateId(candidate.getId());
        candidateDto.setCandidatePhone(candidate.getPhone());
        candidateDto.setCandidateName(candidate.getFullName());
        candidateDto.setCandidateDob(candidate.getDob().atStartOfDay());
        candidateDto.setCandidateEmail(candidate.getEmail());
        Address address = candidate.getAddress();
        candidateDto.setCandidateCity(address.getCity());
        candidateDto.setCandidateZipcode(address.getZipcode());
        candidateDto.setCandidateStreet(address.getStreet());
        candidateDto.setCandidateAddressNumber(address.getNumber());
        candidateDto.setCandidateCountry(address.getCountry().name());
        List<CandidateSkillDto> skillDtoList = candidate.getCandidateSkills().stream()
                .map(CandidateUtils::convertSkillToDto)
                .collect(Collectors.toList());

        candidateDto.setCandidateSkillDtoList(skillDtoList);
        return candidateDto;
    }

    public static CandidateSkillDto convertSkillToDto(CandidateSkill candidateSkill) {
        CandidateSkillDto candidateSkillDto = new CandidateSkillDto();
        candidateSkillDto.setSkillName(candidateSkill.getSkill().getSkillName());
        candidateSkillDto.setSkillType(candidateSkill.getSkill().getType().name());
        candidateSkillDto.setSkillLevel(candidateSkill.getSkillLevel().name());
        return candidateSkillDto;
    }
}
