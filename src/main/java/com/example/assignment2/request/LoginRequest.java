package com.example.assignment2.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "username khong duoc trong")
    private String username;

    @NotEmpty(message = "password khong duoc trong")
    private String password;

    private Integer trangThai;
}
