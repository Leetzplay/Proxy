package padroesestruturais.proxy;

import java.util.List;

public interface INubank {
    List<String> obterDadosNubank();
    Float obterValores(Usuario usuario);
}
