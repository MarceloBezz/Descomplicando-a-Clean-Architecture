package br.com.alura.codechella.infra.controller;

import java.time.LocalDate;

public record UsuarioDTO(
    String nome,
    String cpf,
    LocalDate nascimento,
    String email
) {

}
