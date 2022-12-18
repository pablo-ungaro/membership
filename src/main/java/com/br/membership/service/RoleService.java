package com.br.membership.service;

import com.br.membership.dto.input.CreateRoleDto;
import com.br.membership.mapper.RoleMapper;
import com.br.membership.model.Role;
import com.br.membership.repository.RoleRepository;
import com.br.membership.util.StringUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role create(CreateRoleDto newRole) {
        var roleModel = RoleMapper.toDomain(newRole);
        roleModel.setId(UUID.randomUUID().toString());
        roleModel.setValue(StringUtils.toSnakeCase(newRole.getDescription()));
        return roleRepository.save(roleModel);
    }

    public Role findByValue(String value) {
        return roleRepository.findByValue(value).orElseThrow(() -> new EntityNotFoundException());
    }

}
