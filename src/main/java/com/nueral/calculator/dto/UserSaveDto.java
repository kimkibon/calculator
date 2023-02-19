package com.nueral.calculator.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSaveDto {
    private String username;
    private String password;
    private String role;
    private Long id;
}
