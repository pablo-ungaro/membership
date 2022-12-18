package com.br.membership.service;

import com.br.membership.dto.output.TeamDto;
import com.br.membership.dto.output.UserDto;
import com.br.membership.repository.ECoreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ECoreService {
    private final ECoreRepository eCoreRepository;

    public TeamDto findTeamById(String id) {
        TeamDto team = eCoreRepository.findTeamById(id).orElseThrow(() -> new EntityNotFoundException());
        return team;
    }

    public UserDto findUserById(String id) {
        return eCoreRepository.findUserById(id).orElseThrow(() -> new EntityNotFoundException());
    }
}
