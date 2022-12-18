package com.br.membership.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Collections;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team extends Base {
    @Id
    private String id;

    private String name;

    @OneToOne
    private User teamLead;

    @OneToMany
    @Builder.Default
    @Cascade(CascadeType.ALL)
    private List<TeamMember> members = Collections.emptyList();
}
