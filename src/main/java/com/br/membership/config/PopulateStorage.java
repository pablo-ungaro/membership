package com.br.membership.config;

import com.br.membership.consts.DefaultRole;
import com.br.membership.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PopulateStorage implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        roleRepository.save(DefaultRole.DEVELOPER.getRole());
        roleRepository.save(DefaultRole.PRODUCT_OWNER.getRole());
        roleRepository.save(DefaultRole.TESTER.getRole());
    }
}
