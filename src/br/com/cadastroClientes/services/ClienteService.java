package br.com.cadastroClientes.services;

import br.com.cadastroClientes.dao.generics.IGenericDao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.exception.ClienteNaoEncontradoException;
import br.com.cadastroClientes.services.generics.GenericServices;

import java.util.List;

public class ClienteService extends GenericServices<Cliente> implements IClienteServices {
    private static ClienteService uniqueService;

    private ClienteService (IGenericDao<Cliente> dao) {
        super(dao);
    }

    public static ClienteService service (IGenericDao<Cliente> dao) {
        if (uniqueService != null) {
            return uniqueService;
        } else {
            return new ClienteService(dao);
        }
    }

    @Override
    public Cliente consultar (String cpf) {
        List<Cliente> listaClientes = super.consultarObjetos();

        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException();
    }

    @Override
    public void excluir (String cpf) {
        List<Cliente> listaClientes = super.consultarObjetos();

        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                super.excluir(cliente.getId());
            }
        }
    }

    @Override
    public void atualizar (Cliente cliente) {
        List<Cliente> clientes = super.consultarObjetos();

        boolean flag = false;

        for (Cliente clienteSalvo : clientes) {
            if (clienteSalvo.getCpf().equals(cliente.getCpf())) {
                cliente.setId(Integer.parseInt(clienteSalvo.getId()));
                flag = true;
            }
        }

        if (flag) {
            super.atualizar(cliente);
        } else {
            super.salvar(cliente);
        }
    }
}
