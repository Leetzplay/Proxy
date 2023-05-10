package padroesestruturais.proxy;

import java.util.List;

public class NubankProxy implements INubank {

    private Nubank nubank;

    private Integer codigo;

    public NubankProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosNubank() {
        if (this.nubank == null) {
            this.nubank = new Nubank(this.codigo);
        }
        return this.nubank.obterDadosNubank();
    }

    @Override
    public Float obterValores(Usuario usuario) {
        if (!usuario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.nubank == null) {
            this.nubank = new Nubank(this.codigo);
        }
        return this.nubank.obterValores(usuario);
    }
}
