package com.br.membership.controller;

import com.br.membership.dto.input.CreateRoleDto;
import com.br.membership.dto.output.RoleDto;
import com.br.membership.mapper.RoleMapper;
import com.br.membership.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDto create(@Valid @RequestBody CreateRoleDto createRoleDto) {
        return RoleMapper.toDto(roleService.create(createRoleDto));
    }
}
