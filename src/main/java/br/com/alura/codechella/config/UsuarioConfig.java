package br.com.alura.codechella.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.AtualizaUsuario;
import br.com.alura.codechella.application.usecases.BuscarUsuarioPorId;
import br.com.alura.codechella.application.usecases.CadastrarUsuario;
import br.com.alura.codechella.application.usecases.DeletarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJPA;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

@Configuration
public class UsuarioConfig {
    
    @Bean
    CadastrarUsuario cadastrarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CadastrarUsuario(repositorioDeUsuario);
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    BuscarUsuarioPorId buscarUsuarioPorId(RepositorioDeUsuario repositorioDeUsuario) {
        return new BuscarUsuarioPorId(repositorioDeUsuario);
    }

    @Bean
    AtualizaUsuario atualizaUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new AtualizaUsuario(repositorioDeUsuario);
    }

    @Bean
    DeletarUsuario deletarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new DeletarUsuario(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJPA repositorioDeUsuarioJPA(UsuarioRepository usuarioRepository, UsuarioEntityMapper entityMapper) {
        return new RepositorioDeUsuarioJPA(usuarioRepository, entityMapper);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }
}
