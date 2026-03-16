package org.example.exception;

public class ApostaInvalidaException extends RuntimeException {
    public ApostaInvalidaException(String mensagem) {
        super(mensagem);
    }
}