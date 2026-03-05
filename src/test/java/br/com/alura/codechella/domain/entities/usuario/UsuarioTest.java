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
}
