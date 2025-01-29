package com.dominare.api.model.pessoa;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AtualizarDadosPessoa(
    @NotNull Long id,

    @NotEmpty String nome,
    @NotEmpty String dataDeNascimento,
    @NotEmpty String cpf,
    @NotEmpty String telefone,
    @NotEmpty String bloco,
    @NotEmpty String numeroApartamento,
    @NotEmpty String relacao
) {
    
}
