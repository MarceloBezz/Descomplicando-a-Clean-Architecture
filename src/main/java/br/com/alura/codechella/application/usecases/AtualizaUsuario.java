package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class AtualizaUsuario {
    private final RepositorioDeUsuario repositorio;

    public AtualizaUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario atualizaUsuario(Usuario usuario, Long id) {
        return repositorio.atualizar(usuario, id);
    }

}
