package com.dominare.api.model.people;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AtualizarDadosPeople(
    @NotNull Long id,

    @NotEmpty String nome,
    @NotEmpty String cpf,
    @NotEmpty String bloco,
    @NotEmpty String numeroApartamento,
    String telefone
) {
    
}
