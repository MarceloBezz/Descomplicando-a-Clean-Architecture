package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioTest {
    
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoIncorreto() {
        String cpf = "123456789000";
        
        Assertions.assertThrows(IllegalArgumentException.class, 
            () -> new Usuario(cpf, "Nome teste", LocalDate.now(), "email@email.com"));
    }

    @Test
    public void deveCadastrarUsuario() {
        String cpf = "123.456.789-00";
        
        Assertions.assertDoesNotThrow(() -> new Usuario(cpf, "Nome teste", LocalDate.now(), "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Nome qualquer","123.456.789-00",
                LocalDate.parse("2000-01-01"));
        usuario = fabrica.incluiEndereco("12345-999",45,"apto 201");

        Assertions.assertEquals("Nome qualquer", usuario.getNome());
        Assertions.assertEquals("123.456.789-00", usuario.getCpf());
        Assertions.assertEquals("apto 201", usuario.getEndereco().getComplemento());
    }
}
