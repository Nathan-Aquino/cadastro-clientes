package br.com.cadastroClientes.dao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.exception.*;

import java.util.Collection;

public interface IClienteDao {
    public void salvar (Cliente cliente) throws SobrenomeException, TelefoneException, IdadeException, CpfException, NomeException, EmailException;
    public void atualizar (Cliente cliente) throws SobrenomeException, TelefoneException, IdadeException, CpfException, NomeException, EmailException;
    public void excluir (String cpf) throws ClienteNaoEncontradoException;
    public Cliente consultar (String cpf) throws ClienteNaoEncontradoException;
    public Collection<Cliente> consultarClientes ();
}
