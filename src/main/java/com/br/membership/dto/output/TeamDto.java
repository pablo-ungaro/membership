package com.br.membership.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private String id;
    private String name;
    private String teamLeadId;
    private List<String> teamMemberIds = Collections.emptyList();
}
