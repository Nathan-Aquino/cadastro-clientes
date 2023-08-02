package br.com.cadastroClientes.exception;

public class ClienteNaoEncontradoException extends RuntimeException{
    public ClienteNaoEncontradoException () {
        super("Cliente não encontrado!");
    }
}
