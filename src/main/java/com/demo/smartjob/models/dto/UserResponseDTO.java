package com.demo.smartjob.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class UserResponseDTO {

    private Long id;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private String token;
    private boolean isActive;
}
