package br.com.alura.codechella.infra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.codechella.application.usecases.AtualizaUsuario;
import br.com.alura.codechella.application.usecases.BuscarUsuarioPorId;
import br.com.alura.codechella.application.usecases.CadastrarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CadastrarUsuario cadastrarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final BuscarUsuarioPorId buscarUsuarioPorId;
    private final AtualizaUsuario atualizaUsuario;

    public UsuarioController(CadastrarUsuario cadastrarUsuario, ListarUsuarios listarUsuarios,
                BuscarUsuarioPorId buscarUsuarioPorId, AtualizaUsuario atualizaUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.buscarUsuarioPorId = buscarUsuarioPorId;
        this.atualizaUsuario = atualizaUsuario;
    }

    @PostMapping
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO dto) {
        Usuario usuarioSalvo = cadastrarUsuario
                .cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));

        return new UsuarioDTO(usuarioSalvo.getNome(), usuarioSalvo.getCpf(),
                usuarioSalvo.getNascimento(), usuarioSalvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        List<Usuario> usuarios = listarUsuarios.listarUsuarios();

        return usuarios
                .stream()
                .map(usuario -> new UsuarioDTO(usuario.getNome(), usuario.getCpf(),
                        usuario.getNascimento(), usuario.getEmail()))
                .toList();
    }

    @GetMapping("/{id}")
    public UsuarioDTO listarPorId(@PathVariable Long id) {
        try {
            Usuario usuario = buscarUsuarioPorId.buscarUsuarioPorId(id);
            return new UsuarioDTO(usuario.getNome(), usuario.getCpf(), usuario.getNascimento(), usuario.getEmail());
        } catch (RuntimeException e) {
            return null;
        }
    }
    
    @PutMapping("/{id}")
    public UsuarioDTO atualizar(@RequestBody UsuarioDTO dto, @PathVariable Long id) {
        try {
            var usuarioAtualizado = atualizaUsuario
                    .atualizaUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()), id);
            return new UsuarioDTO(usuarioAtualizado.getNome(), usuarioAtualizado.getCpf(), usuarioAtualizado.getNascimento(), usuarioAtualizado.getEmail());
        } catch (Exception e) {
            return null;
        }
    }
}
