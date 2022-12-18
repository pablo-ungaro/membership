package com.br.membership.controller;

import com.br.membership.dto.input.FilterDto;
import com.br.membership.dto.input.UpdateUserDto;
import com.br.membership.dto.output.UserDto;
import com.br.membership.mapper.UserMapper;
import com.br.membership.service.TeamMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final TeamMemberService teamMemberService;

    @PatchMapping("/{userId}/teams/{teamId}")
    public ResponseEntity<UserDto> update(@Valid @RequestBody UpdateUserDto memberDto, @PathVariable String userId, @PathVariable String teamId) {
        return ResponseEntity.ok(UserMapper.toDto(teamMemberService.update(memberDto, userId, teamId)));
    }

    @GetMapping("/{userId}/teams/{teamId}")
    public ResponseEntity<UserDto> findById(@PathVariable String userId, @PathVariable String teamId) {
        return ResponseEntity.ok(UserMapper.toDto(teamMemberService.findByIdAndTeam(userId, teamId)));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(@Valid FilterDto filterDto) {
        return ResponseEntity.ok(UserMapper.toDto(teamMemberService.findAll(filterDto)));
    }
}
