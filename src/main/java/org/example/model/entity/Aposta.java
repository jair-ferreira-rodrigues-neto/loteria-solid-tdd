package org.example.model.entity;

import lombok.Getter;

import java.util.Collections;
import java.util.Set;

@Getter
public class Aposta {
    private final Set<Integer> numeros;
    private final double valorInvestido;

    public Aposta(Set<Integer> numeros, double valorInvestido) {
        this.numeros = Collections.unmodifiableSet(numeros);
        this.valorInvestido = valorInvestido;
    }

}
