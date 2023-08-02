package br.com.cadastroClientes.exception;

public class ClienteJaExistenteException extends RuntimeException{
    public ClienteJaExistenteException () {
        super("Cpf já existe no sistema!");
    }
}
