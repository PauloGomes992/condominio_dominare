package com.dominare.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quadroDeAvisos")
public class QuadroDeAvisosController {

    @GetMapping
    public String TelaQuadroDeAvisos() {
        return "quadro_de_avisos/quadroDeAvisos";
    }
}