package com.dominare.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @GetMapping
    public String carregarPaginaLogin() {
        return "login/login";
    }

    @GetMapping("/redefinicao")
    public String carregarPaginaRedefinicao() {
        return "login/redefinicao_senha";
    }
 }
