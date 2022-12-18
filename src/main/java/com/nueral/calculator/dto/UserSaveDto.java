package com.nueral.calculator.dto;

import com.nueral.calculator.types.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDto {
    private String username;
    private String password;
    private Role role;
}
