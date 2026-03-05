package br.com.alura.codechella.infra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.codechella.application.usecases.CadastrarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CadastrarUsuario cadastrarUsuario;
    private final ListarUsuarios listarUsuarios;

    public UsuarioController(CadastrarUsuario cadastrarUsuario, ListarUsuarios listarUsuarios) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuarios = listarUsuarios;
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

}
