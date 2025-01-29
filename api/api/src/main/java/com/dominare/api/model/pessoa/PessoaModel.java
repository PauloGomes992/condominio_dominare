package com.dominare.api.model.pessoa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoas")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dataDeNascimento;
    private String cpf;
    private String telefone;
    private String bloco;
    private String numeroApartamento;
    private String relacao;

   

    public PessoaModel(String nome, String dataDeNascimento, String cpf, String telefone, String bloco, String numeroApartamento, String relacao) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.bloco = bloco;
        this.numeroApartamento = numeroApartamento;
        this.relacao = relacao;
    }
    
}
