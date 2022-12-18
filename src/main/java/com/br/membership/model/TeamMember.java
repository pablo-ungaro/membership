package com.br.membership.model;

import com.br.membership.consts.DefaultRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    private User user;

    @OneToOne
    private Team team;

    @OneToOne
    private Role role = DefaultRole.DEVELOPER.getRole();
}
