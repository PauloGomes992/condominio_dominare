package com.dominare.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/votacao")
public class VotacaoController {

    @GetMapping
    public String TelaVotacao(){
        return "votacao/votacao";
    }
}
