package com.dominare.api.model.pessoa;


public record DadosCadastrosPessoa(
        
        String nome,
        String dataDeNascimento,
        String cpf,
        String telefone,
        String bloco,
        String numeroApartamento,
        String relacao) {

}
