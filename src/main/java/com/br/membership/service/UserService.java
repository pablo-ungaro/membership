package com.br.membership.service;

import com.br.membership.dto.output.UserDto;
import com.br.membership.mapper.UserMapper;
import com.br.membership.model.User;
import com.br.membership.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveOrUpdate(UserDto userDto) {
        return userRepository.save(UserMapper.toDomain(userDto));
    }
}
