package br.com.cadastroClientes.exception;

public class ClienteJaExistenteException extends Exception{
    public ClienteJaExistenteException () {
        super("Cpf já existe no sistema!");
    }
}
