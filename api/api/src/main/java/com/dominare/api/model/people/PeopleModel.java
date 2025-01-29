package com.dominare.api.model.people;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "peoples")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class PeopleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String bloco;
    private String numeroApartamento;
    private String telefone;

    

    public PeopleModel(String nome, String cpf, String bloco,String numeroApartamento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.bloco = bloco;
        this.numeroApartamento = numeroApartamento;
        this.telefone = telefone;
    }
}
