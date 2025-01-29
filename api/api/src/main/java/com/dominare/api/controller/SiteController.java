package com.dominare.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SiteController {
    @GetMapping
    public String carregarPaginaIndex() {
        return "index";
    }

    @GetMapping("/sobre")
    public String carregarPaginaSobre() {
        return "principal/sobre_nos";
    }

    @GetMapping("/parceiros")
    public String carregarPaginaParceiros() {
        return "principal/parceiros";
    }

    @GetMapping("/contrate")
    public String carregarPaginaContrate() {
        return "principal/contrate";
    }

}
