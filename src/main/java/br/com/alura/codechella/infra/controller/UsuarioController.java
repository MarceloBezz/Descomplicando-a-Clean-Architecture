package br.com.alura.codechella.infra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.codechella.application.usecases.CadastrarUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CadastrarUsuario cadastrarUsuario;

    public UsuarioController(CadastrarUsuario cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    @PostMapping
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO dto) {
        Usuario usuarioSalvo = 
                cadastrarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        
        return new UsuarioDTO(usuarioSalvo.getNome(), usuarioSalvo.getCpf(),
                usuarioSalvo.getNascimento(), usuarioSalvo.getEmail());
    }
    
}
