package br.com.cadastroClientes.dao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.util.Verificacao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteDao implements IClienteDao{

    public Map<String, Cliente> clientes;

    public ClienteDao () {
        this.clientes = new HashMap<>();
    }

    @Override
    public void salvar(Cliente cliente) {
        Integer checagem = Verificacao.verificaCliente(cliente);
        if (checagem.equals(0)) {
            clientes.put(cliente.getCpf(), cliente);
        } else {
            //TO-DO
        }
    }

    @Override
    public void atualizar(Cliente cliente) {

    }

    @Override
    public void excluir(String cpf) {

    }

    @Override
    public Cliente consultar(String cpf) {
        return null;
    }

    @Override
    public Collection<Cliente> consultarClientes() {
        return null;
    }
}
