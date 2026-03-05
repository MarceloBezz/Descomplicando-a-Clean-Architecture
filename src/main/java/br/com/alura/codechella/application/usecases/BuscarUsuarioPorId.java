package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class BuscarUsuarioPorId {
    private final RepositorioDeUsuario repositorio;

    public BuscarUsuarioPorId(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return repositorio.buscarPorId(id);
    }
}