package br.com.cadastroClientes.dao;
import br.com.cadastroClientes.dao.generics.GenericDao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.exception.*;
import br.com.cadastroClientes.util.Verificacao;

public class ClienteDao extends GenericDao<Cliente> implements IClienteDao {

    public ClienteDao () {
        super();
    }

    @Override
    public void salvar(Cliente cliente) throws SobrenomeException, TelefoneException, IdadeException, CpfException, NomeException, EmailException {
        Integer checagem = Verificacao.verificaCliente(cliente);
        if (checagem.equals(0)) {
            super.salvar(cliente);
        } else {
            ManipuladorDeExcecao.lancamentoDeExcecao(checagem);
        }
    }

    @Override
    public void atualizar(Cliente cliente) throws SobrenomeException, TelefoneException, IdadeException, CpfException, NomeException, EmailException {
        Integer checagem = Verificacao.verificaCliente(cliente);
        if (checagem.equals(0)) {
            super.atualizar(cliente);
        } else {
            ManipuladorDeExcecao.lancamentoDeExcecao(checagem);
        }
    }

    @Override
    public void excluir(String identificador) throws ClienteNaoEncontradoException {
        try {
            super.excluir(identificador);
        } catch (RuntimeException ex) {
            throw new ClienteNaoEncontradoException();
        }
    }

    @Override
    public Cliente consultar(String identificador) throws ClienteNaoEncontradoException {
        try {
            return super.consultar(identificador);
        } catch (RuntimeException ex) {
            throw new ClienteNaoEncontradoException();
        }
    }
}
