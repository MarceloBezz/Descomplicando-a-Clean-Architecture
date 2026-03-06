package br.com.alura.codechella.infra.gateways;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {
    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarios;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarios
                .stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public Usuario atualizar(Usuario usuario, Long id) {
        return usuarios
                .stream()
                .filter(u -> u.getId().equals(id))
                .map(u -> {
                    u.setCpf(usuario.getCpf());
                    u.setEmail(usuario.getEmail());
                    u.setEndereco(usuario.getEndereco());
                    u.setNascimento(usuario.getNascimento());
                    return u;
                })
                .findFirst()
                .orElseThrow();

    }

    @Override
    public void deletar(Long id) {
        usuarios.remove(buscarPorId(id));
    }

}
