package org.example.model.entity;

import org.example.exception.ApostaInvalidaException;

import java.util.Collections;
import java.util.Set;

public class Aposta {
    private final Set<Integer> numeros;
    private final double valorInvestido;

    public Aposta(Set<Integer> numeros, double valorInvestido) {
        if (numeros == null || numeros.size() < 6 || numeros.size() > 15) {
            throw new ApostaInvalidaException("Uma aposta deve conter entre 6 e 15 dezenas.");
        }

        this.numeros = Collections.unmodifiableSet(numeros);
        this.valorInvestido = valorInvestido;
    }

    public Set<Integer> getNumeros() {
        return numeros;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }
}