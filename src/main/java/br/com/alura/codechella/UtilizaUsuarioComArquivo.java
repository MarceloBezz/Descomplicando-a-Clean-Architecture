package br.com.alura.codechella;

import java.io.IOException;
import java.time.LocalDate;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

public class UtilizaUsuarioComArquivo {
    public static void main(String[] args) throws IOException {
        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();

        repositorio.cadastrarUsuario(new Usuario("123.456.789-00", "Marcelo",
                LocalDate.now(), "email@email.com"));
        repositorio.cadastrarUsuario(new Usuario("123.456.789-00", "João",
                LocalDate.now(), "email@email.com"));
        repositorio.cadastrarUsuario(new Usuario("123.456.789-00", "Carlos",
                LocalDate.now(), "email@email.com"));
        repositorio.cadastrarUsuario(new Usuario("123.456.789-00", "Fernando",
                LocalDate.now(), "email@email.com"));

        System.out.println(repositorio.listarTodos());

        repositorio.gravaEmArquivo("Lista de usuários.txt");
    }
}
