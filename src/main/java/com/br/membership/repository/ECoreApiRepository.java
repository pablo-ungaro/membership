package com.br.membership.repository;

import com.br.membership.dto.output.TeamDto;
import com.br.membership.dto.output.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RequiredArgsConstructor
@Log
@CacheConfig(cacheManager = "eCoreApiCacheManager")
public class ECoreApiRepository implements ECoreRepository {
    private final RestTemplate restTemplate;

    @Value("${e-core.api.base-url}")
    private String eCoreBaseUrl;

    @Override
    @Cacheable("eCoreUser")
    public Optional<UserDto> findUserById(String id) {
        log.info("Getting user %s".formatted(id));
        return Optional.ofNullable(restTemplate.getForObject("%s/users/%s".formatted(eCoreBaseUrl, id), UserDto.class));
    }

    @Override
    @Cacheable("eCoreTeam")
    public Optional<TeamDto> findTeamById(String id) {
        log.info("Getting team %s".formatted(id));
        return Optional.ofNullable(restTemplate.getForObject("%s/teams/%s".formatted(eCoreBaseUrl, id), TeamDto.class));
    }
}
