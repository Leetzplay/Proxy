package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NubankProxyTest {

    @BeforeEach
    void setUp() {
        Banco.addVisitante(new Nubank(102, "Enio", "Nubank",1040.0f));
        Banco.addVisitante(new Nubank(404, "Jaime", "Caixa",800.0f));
    }

    @Test
    void deveRetornarDadosNubank() {
        NubankProxy nubank = new NubankProxy(102);

        assertEquals(Arrays.asList("Enio", "Nubank"), nubank.obterDadosNubank());
    }

    @Test
    void deveRetonarUsuarioAbrirNubank() {
        Usuario usuario = new Usuario("Tico", true);
        NubankProxy nubank = new NubankProxy(404);

        assertEquals(800.0f, nubank.obterValores(usuario));
    }


    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoAbrirNubank() {
        try {
            Usuario usuario = new Usuario("Mane", false);
            NubankProxy visitante = new NubankProxy(404);

            visitante.obterValores(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }

    }
}