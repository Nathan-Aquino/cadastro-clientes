package br.com.cadastroClientes.dao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.exception.*;
import br.com.cadastroClientes.util.Verificacao;

import java.util.*;

public class ClienteDao implements IClienteDao{

    public Map<String, Cliente> clientes;

    public ClienteDao () {
        this.clientes = new HashMap<>();
    }

    @Override
    public void salvar(Cliente cliente) throws SobrenomeException, TelefoneException, IdadeException, CpfException, NomeException, EmailException {
        Integer checagem = Verificacao.verificaCliente(cliente);
        if (checagem.equals(0)) {
            clientes.put(cliente.getCpf(), cliente);
        } else {
            ManipuladorDeExcecao.lancamentoDeExcecao(checagem);
        }
    }

    @Override
    public void atualizar(Cliente cliente) throws SobrenomeException, TelefoneException, IdadeException, CpfException, NomeException, EmailException {
        Integer checagem = Verificacao.verificaCliente(cliente);
        if (checagem.equals(0)) {
            clientes.replace(cliente.getCpf(), cliente);
        } else {
            ManipuladorDeExcecao.lancamentoDeExcecao(checagem);
        }
    }

    @Override
    public void excluir(String cpf) throws ClienteNaoEncontradoException {
        if (clientes.containsKey(cpf)) {
            clientes.remove(cpf);
        } else {
            throw new ClienteNaoEncontradoException();
        }
    }

    @Override
    public Cliente consultar(String cpf) throws ClienteNaoEncontradoException {
        if (clientes.containsKey(cpf)) {
            return clientes.get(cpf);
        } else {
            throw new ClienteNaoEncontradoException();
        }
    }

    @Override
    public List<Cliente> consultarClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        for (Map.Entry<String, Cliente> cliente : this.clientes.entrySet()) {
            clientes.add(cliente.getValue());
        }
        return clientes;
    }
}
