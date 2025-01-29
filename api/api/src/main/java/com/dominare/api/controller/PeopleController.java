package com.dominare.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.dominare.api.model.people.AtualizarDadosPeople;
import com.dominare.api.model.people.PeopleModel;
import com.dominare.api.model.people.PeopleRepository;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/sistema/visitante")
@Controller

public class PeopleController {

    @Autowired
    private PeopleRepository repository;

    // MÉTODOS HTTPS

    // Get
    @GetMapping("/")
    public String listarPeoples() {
        return "sistema/visitante/visitante";
    }

    @GetMapping("/pesquisar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("peoples", repository.findAll());
        return "sistema/visitante/listaVisitante";
    }

    @GetMapping("/cadastro")
    public String cadastrarVisitante(Model model) {
        model.addAttribute("people", new PeopleModel());
        return "sistema/visitante/cadastroVisitante";
    }

    // Post
    // @PostMapping("/cadastroPeople")
    @PostMapping("/cadastro")
    @Transactional
    public String salvarPeople(@ModelAttribute PeopleModel people) {
        repository.save(people);
        return "redirect:/sistema/visitante/pesquisar";
    }

    @GetMapping("/atualizar/{id}")
    // PathVariable > recolhe dados posto no html de origem a requisição
    public String carregarFormularioAtualizacao(@PathVariable Long id, Model model) {
        PeopleModel people = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + id));
        model.addAttribute("people", people);
        return "sistema/visitante/atualizarVisitante";
    }

    // Put
    @PutMapping("/atualizar/{id}")
    @Transactional
    public String atualizarPessoa(@PathVariable Long id, @ModelAttribute AtualizarDadosPeople dados) {
        PeopleModel people = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + id));

        people.setNome(dados.nome());
        people.setCpf(dados.cpf());
        people.setBloco(dados.bloco());
        people.setNumeroApartamento(dados.numeroApartamento());
        people.setTelefone(dados.telefone());

        repository.save(people);
        return "redirect:/sistema/visitante/pesquisar";
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    @Transactional
    public String deletarPessoa(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/sistema/visitante/pesquisar";
    }
}
