package com.br.membership.service;

import com.br.membership.consts.DefaultRole;
import com.br.membership.dto.output.TeamDto;
import com.br.membership.dto.output.UserDto;
import com.br.membership.mapper.TeamMapper;
import com.br.membership.model.Team;
import com.br.membership.model.TeamMember;
import com.br.membership.model.User;
import com.br.membership.repository.TeamMemberRepository;
import com.br.membership.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;

    private final UserService userService;

    private final ECoreService eCoreService;

    public Team findById(String id) {
        return teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public void updateData(String teamId) {
        TeamDto teamDto = eCoreService.findTeamById(teamId);
        UserDto teamLead = eCoreService.findUserById(teamDto.getTeamLeadId());
        userService.saveOrUpdate(teamLead);
        Team team = teamRepository.save(TeamMapper.toDomain(teamDto, teamLead));
        teamDto.getTeamMemberIds().stream().forEach(memberId -> {
            UserDto userDto = eCoreService.findUserById(memberId);
            User saved = userService.saveOrUpdate(userDto);
            Optional<TeamMember> teamMember = teamMemberRepository.findByUserIdAndTeamId(userDto.getId(), teamId);
            team.getMembers().add(teamMember.orElse(TeamMember.builder()
                    .user(saved)
                    .team(team)
                    .role(DefaultRole.DEVELOPER.getRole()).build()));

        });
        teamRepository.save(team);
    }
}
