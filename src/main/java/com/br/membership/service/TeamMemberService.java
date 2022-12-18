package com.br.membership.service;

import com.br.membership.controller.CustomExceptionHandler;
import com.br.membership.dto.input.FilterDto;
import com.br.membership.dto.input.UpdateUserDto;
import com.br.membership.model.Role;
import com.br.membership.model.Team;
import com.br.membership.model.TeamMember;
import com.br.membership.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamMemberService {
    private final RoleService roleService;
    private final TeamMemberRepository teamMemberRepository;
    private final TeamService teamService;

    public TeamMember findByIdAndTeam(String userId, String teamId) {
        teamService.updateData(teamId);
        return teamMemberRepository.findByUserIdAndTeamId(userId, teamId).orElseThrow(CustomExceptionHandler::notFound);
    }

    public List<TeamMember> findAll(FilterDto filterDto) {
        teamService.updateData(filterDto.getTeamId());
        Team team = teamService.findById(filterDto.getTeamId());
        return team.getMembers().stream()
                .filter(teamMember -> teamMember.getRole().getValue().equals(filterDto.getRole()))
                .toList();
    }

    public TeamMember update(UpdateUserDto updateUserDto, String userId, String teamId) {
        teamService.updateData(teamId);
        Role role = roleService.findByValue(updateUserDto.getRole());
        TeamMember teamMember = teamMemberRepository.findByUserIdAndTeamId(userId, teamId).orElseThrow(CustomExceptionHandler::notFound);
        teamMember.setRole(role);
        return teamMemberRepository.save(teamMember);
    }
}
