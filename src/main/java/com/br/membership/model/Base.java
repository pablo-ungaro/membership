package com.br.membership.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class Base {
    @LastModifiedDate
    protected LocalDateTime updatedAt;

    @CreatedDate
    protected LocalDateTime createdAt;

    protected LocalDateTime deletedAt;
}
