package com.dominare.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.dominare.api.model.pessoa.AtualizarDadosPessoa;
import com.dominare.api.model.pessoa.PessoaModel;
import com.dominare.api.model.pessoa.PessoaRepository;

import jakarta.transaction.Transactional;

@RequestMapping("/sistema/morador")
@Controller

public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    // MÉTODOS HTTPS

    // Get
    @GetMapping("/")
    public String listarPessoas() {
        return "sistema/morador/morador";
    }

    @GetMapping("/pesquisar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pessoas", repository.findAll());
        return "sistema/morador/listaMorador";
    }

    @GetMapping("/cadastro")
    public String cadastrarMorador(Model model) {
        model.addAttribute("pessoa", new PessoaModel());
        return "sistema/morador/cadastroMorador";
    }

    // Post
    // @PostMapping("/cadastroPessoa")
    @PostMapping("/cadastro")
    @Transactional
    public String salvarPessoa(@ModelAttribute PessoaModel pessoa) {
        repository.save(pessoa);
        return "redirect:/sistema/morador/pesquisar";
    }

    @GetMapping("/atualizar/{id}")
    // pATHvARIABLE > recolhe dados posto no html de origem a requisição
    public String carregarFormularioAtualizacao(@PathVariable Long id, Model model) {
        PessoaModel pessoa = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + id));
        model.addAttribute("pessoa", pessoa);
        return "sistema/morador/atualizarMorador";
    }

    // Put
    @PutMapping("/atualizar/{id}")
    @Transactional
    public String atualizarPessoa(@PathVariable Long id, @ModelAttribute AtualizarDadosPessoa dados) {
        PessoaModel pessoa = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + id));

        pessoa.setNome(dados.nome());
        pessoa.setDataDeNascimento(dados.dataDeNascimento());
        pessoa.setCpf(dados.cpf());
        pessoa.setTelefone(dados.telefone());
        pessoa.setBloco(dados.bloco());
        pessoa.setNumeroApartamento(dados.numeroApartamento());
        pessoa.setRelacao(dados.relacao());

        repository.save(pessoa);
        return "redirect:/sistema/morador/pesquisar";

    }

    // Delete
    @DeleteMapping("/delete/{id}")
    @Transactional
    public String deletarMorador(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/sistema/morador/pesquisar";
    }
    
}


