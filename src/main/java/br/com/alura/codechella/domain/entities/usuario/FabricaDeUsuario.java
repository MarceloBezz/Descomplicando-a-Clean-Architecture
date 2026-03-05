package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import br.com.alura.codechella.domain.Endereco;

public class FabricaDeUsuario {
    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento) {
        usuario = new Usuario(cpf, nome, nascimento, "");
        return usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento) {
        usuario.setEndereco(new Endereco(cep, numero, complemento));
        return usuario;
    }
}
