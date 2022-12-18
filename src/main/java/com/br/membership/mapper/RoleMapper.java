package com.br.membership.mapper;

import com.br.membership.consts.DefaultRole;
import com.br.membership.dto.input.CreateRoleDto;
import com.br.membership.dto.output.RoleDto;
import com.br.membership.model.Role;

public class RoleMapper {

    public static RoleDto toDto(Role role) {
        return RoleDto.builder().id(role.getId())
                .description(role.getDescription())
                .value(role.getValue()).build();
    }

    public static Role toDomain(RoleDto role) {
        return Role.builder().id(role.getId())
                .description(role.getDescription())
                .value(role.getValue()).build();
    }

    public static Role toDomain(CreateRoleDto role) {
        return Role.builder()
                .description(role.getDescription())
                .build();
    }

    public static Role toDefaultDomain(DefaultRole role) {
        return Role.builder().id(role.getId())
                .description(role.getDescription())
                .value(role.getValue()).build();
    }
}
