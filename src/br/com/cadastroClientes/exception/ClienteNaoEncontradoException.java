package br.com.cadastroClientes.exception;

public class ClienteNaoEncontradoException extends Exception{
    public ClienteNaoEncontradoException () {
        super("Cliente não encontrado!");
    }
}
