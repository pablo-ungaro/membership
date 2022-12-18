package com.br.membership.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@SQLDelete(sql = "UPDATE User SET deletedAt=now() WHERE id=?")
//@Where(clause = "deletedAt is NULL")
public class Role extends Base {
    @Id
    private String id;

    @NotBlank(message = "description is mandatory")
    private String description;

    @NotBlank(message = "value is mandatory")
    @Column(unique = true)
    private String value;
}
