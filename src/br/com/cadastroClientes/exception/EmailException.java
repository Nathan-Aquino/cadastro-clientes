package br.com.cadastroClientes.exception;

public class EmailException extends RuntimeException{
    public EmailException(String message) {
        super(message);
    }
}
