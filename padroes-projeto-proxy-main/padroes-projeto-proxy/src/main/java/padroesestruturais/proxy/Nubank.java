package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Nubank implements INubank {

    private Integer codigo;
    private String nome;
    private String local;
    private Float valor;


    public Nubank(int codigo) {
        this.codigo = codigo;
        Nubank objeto = Banco.getNubank(codigo);
        this.nome = objeto.nome;
        this.local = objeto.local;
        this.valor = objeto.valor;
    }

    public Nubank(Integer codigo, String nome, String local, Float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.local = local;
        this.valor = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosNubank() {
        return Arrays.asList(this.nome, this.local);
    }

    @Override
    public Float obterValores(Usuario usuario) {
        return this.valor;
    }
}
