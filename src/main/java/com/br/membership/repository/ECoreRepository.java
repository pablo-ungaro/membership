package com.br.membership.repository;

import com.br.membership.dto.output.TeamDto;
import com.br.membership.dto.output.UserDto;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ECoreRepository {
    Optional<UserDto> findUserById(String id);

    Optional<TeamDto> findTeamById(String id);
}
