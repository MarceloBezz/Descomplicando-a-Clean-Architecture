package br.com.alura.codechella.infra.gateways;

import java.util.List;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

public class RepositorioDeUsuarioJPA implements RepositorioDeUsuario {

    private final UsuarioRepository repository;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJPA(UsuarioRepository repository, UsuarioEntityMapper entityMapper) {
        this.repository = repository;
        this.mapper = entityMapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        UsuarioEntity entity = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ID não encontrado!"));

        return mapper.toDomain(entity);

    }

    @Override
    public Usuario atualizar(Usuario usuario, Long id) {
        var usuarioBD = repository.findById(id).get();
        if (usuarioBD != null) {
            usuarioBD.setNome(usuario.getNome());
            usuarioBD.setEmail(usuario.getEmail());
            usuarioBD.setNascimento(usuario.getNascimento());
            usuarioBD.setCpf(usuario.getCpf());
            repository.save(usuarioBD);
            return mapper.toDomain(usuarioBD);
        }

        throw new RuntimeException("Usuário não encontrado!");
    }

    @Override
    public void deletar(Long id) {
        var usuarioBD = repository.findById(id).get();
        if (usuarioBD != null) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }
    
}
