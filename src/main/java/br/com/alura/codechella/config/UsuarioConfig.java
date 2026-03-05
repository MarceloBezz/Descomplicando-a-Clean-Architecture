package br.com.alura.codechella.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.CadastrarUsuario;
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
    RepositorioDeUsuarioJPA repositorioDeUsuarioJPA(UsuarioRepository usuarioRepository, UsuarioEntityMapper entityMapper) {
        return new RepositorioDeUsuarioJPA(usuarioRepository, entityMapper);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }
}
