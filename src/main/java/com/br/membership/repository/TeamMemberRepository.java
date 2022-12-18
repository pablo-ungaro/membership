package com.br.membership.repository;

import com.br.membership.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, String> {
    Optional<TeamMember> findByUserIdAndTeamId(String userId, String teamId);
}
