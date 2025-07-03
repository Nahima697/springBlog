package com.hb.cda.project_blog.controller;

import com.hb.cda.project_blog.entity.User;
import com.hb.cda.project_blog.repository.UserRepository;
import com.hb.cda.project_blog.security.RegisterFormDto;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String displayRegister(Model model) {
        model.addAttribute("registerFormDto", new RegisterFormDto());
        return "register-form";
    }

    @PostMapping("/register")
    public String processRegister(@Valid RegisterFormDto dto, BindingResult bindingResult, Model model) {

        if( userRepository.findByUsername(dto.getUsername()).isPresent() ) {
            bindingResult.rejectValue("username", "username.exists");
        }

        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "register-form";
        }
        User user = new User();
        user.setUsername(dto.getUsername());

        if(!dto.getPassword().equals(dto.getConfirmPassword())) {
            bindingResult.rejectValue("password", "password.nomatch");
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "register-form";
        }
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String displayLogin(Model model) {
        model.addAttribute("user", new User());
        return "login-form ";
    }
}
