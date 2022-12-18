package com.br.membership.mapper;

import com.br.membership.dto.output.TeamDto;
import com.br.membership.dto.output.UserDto;
import com.br.membership.model.Team;

import java.util.List;

public class TeamMapper {
    public static TeamDto toDto(Team team) {
        return TeamDto.builder()
                .id(team.getId())
                .name(team.getName())
                .teamLeadId(team.getTeamLead().getId())
                .teamMemberIds(team.getMembers().stream().map(u -> u.getId()).toList())
                .build();
    }

    public static List<TeamDto> toDto(List<Team> member) {
        return member.stream().map(TeamMapper::toDto).toList();
    }

    public static Team toDomain(TeamDto teamDto, UserDto teamLead) {
        return Team.builder()
                .id(teamDto.getId())
                .name(teamDto.getName())
                .teamLead(UserMapper.toDomain(teamLead))
                .build();
    }
}
