package com.dominare.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominare.api.model.apartamento.entrega.EntregaModel;
import com.dominare.api.model.apartamento.entrega.EntregasRepository;
import jakarta.transaction.Transactional;

@RequestMapping("/entrega")
@RestController
public class EntregaController {
    @Autowired
    private EntregasRepository repository;

    @GetMapping("/")
    public String listarEntregas (Model model){
        model.addAttribute("entregas", repository.findAll());
        return "listarEntregas";
    }

    @GetMapping("/cadastrar")
    public String mostrarFormulario (Model model){
        model.addAttribute("entrega", new EntregaModel());
        return "cadastroEntregas";
    }
    
    @PostMapping
    @Transactional
    public String cadastrarEntrega(EntregaModel entrega){
        repository.save(entrega);
        return "redirect:/";
    }
}
