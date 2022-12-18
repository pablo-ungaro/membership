package com.br.membership.repository;

import com.br.membership.dto.output.TeamDto;
import com.br.membership.dto.output.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RequiredArgsConstructor
@Log
@CacheConfig(cacheManager = "eCoreApiCacheManager")
public class ECoreApiRepository implements ECoreRepository {
    private final RestTemplate restTemplate;

    @Override
    @Cacheable("eCoreUser")
    public Optional<UserDto> findUserById(String id) {
        log.info("Getting user %s".formatted(id));
        return Optional.ofNullable(restTemplate.getForObject("https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/users/%s".formatted(id), UserDto.class));
    }

    @Override
    @Cacheable("eCoreTeam")
    public Optional<TeamDto> findTeamById(String id) {
        log.info("Getting team %s".formatted(id));
        return Optional.ofNullable(restTemplate.getForObject("https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/teams/%s".formatted(id), TeamDto.class));
    }
}
