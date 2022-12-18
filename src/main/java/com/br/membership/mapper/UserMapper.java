package com.br.membership.mapper;

import com.br.membership.dto.output.UserDto;
import com.br.membership.model.TeamMember;
import com.br.membership.model.User;

import java.util.List;

public class UserMapper {

    public static UserDto toDto(TeamMember member) {
        return UserDto.builder()
                .id(member.getId())
                .firstName(member.getUser().getFirstName())
                .lastName(member.getUser().getLastName())
                .displayName(member.getUser().getDisplayName())
                .location(member.getUser().getLocation())
                .avatarUrl(member.getUser().getAvatarUrl())
                .role(RoleMapper.toDto(member.getRole()))
                .build();
    }

    public static User toDomain(UserDto user) {
        return User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .displayName(user.getDisplayName())
                .location(user.getLocation())
                .avatarUrl(user.getAvatarUrl())
                .build();
    }

    public static List<UserDto> toDto(List<TeamMember> members) {
        return members.stream().map(m -> UserMapper.toDto(m)).toList();
    }
}
