package padroesestruturais.proxy;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private static Map<Integer, Nubank> nubanks = new HashMap<>();

    public static Nubank getNubank(Integer codigo) {
        return nubanks.get(codigo);
    }

    public static void addVisitante(Nubank nubank) {
        nubanks.put(nubank.getCodigo(), nubank);
    }
}
