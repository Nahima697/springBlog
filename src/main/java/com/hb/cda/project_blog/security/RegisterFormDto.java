package com.hb.cda.project_blog.security;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterFormDto {
    @NotEmpty
    @Size(min=2, max=30)
    String username;
    @NotEmpty
    String password;
    @NotEmpty
    String confirmPassword;

    public RegisterFormDto() {}

    public RegisterFormDto(String username, String password,String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

