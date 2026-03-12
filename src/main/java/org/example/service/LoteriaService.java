package org.example.service;

import org.example.model.entity.Aposta;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LoteriaService {
    private static final int MIN = 1;
    private static final int MAX = 60;
    private static final int QTD_SORTEIO = 6;
    private final Random random = new Random();

    public Set<Integer> filtrarNumerosValidos(List<Integer> entrada) {
        return entrada.stream()
                .filter(n -> n >= MIN && n <= MAX)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<Integer> realizarSorteio() {
        Set<Integer> sorteados = new TreeSet<>();
        while (sorteados.size() < QTD_SORTEIO) {
            sorteados.add(random.nextInt(MAX) + 1);
        }
        return sorteados;
    }

    public double calcularPremio(Aposta aposta, Set<Integer> sorteioOficial) {
        long acertos = aposta.getNumeros().stream()
                .filter(sorteioOficial::contains)
                .count();

        if (acertos == 6) return aposta.getValorInvestido();
        if (acertos == 5) return aposta.getValorInvestido() * 0.20;
        if (acertos == 4) return aposta.getValorInvestido() * 0.05;

        return 0.0;
    }
}
