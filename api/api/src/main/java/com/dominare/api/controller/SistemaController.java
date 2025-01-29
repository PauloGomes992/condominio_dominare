package com.dominare.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sistema")
public class SistemaController {
    
    @GetMapping
    public String carregarPaginaSistema() {
        return "sistema/model-sidebar";
    }

    @GetMapping("/morador") 
    public String carregaPaginaMoradores() {
        return "sistema/morador/morador";
    }

    @GetMapping("/visitante") 
    public String carregaPaginaVisitantes() {
        return "sistema/visitante/visitante";
    }
}
