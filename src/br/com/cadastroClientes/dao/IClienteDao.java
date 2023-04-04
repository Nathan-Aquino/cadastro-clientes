package br.com.cadastroClientes.dao;
import br.com.cadastroClientes.domain.Cliente;
import java.util.Collection;

public interface IClienteDao {
    public void salvar (Cliente cliente);
    public void atualizar (Cliente cliente);
    public void excluir (String cpf);
    public Cliente consultar (String cpf);
    public Collection<Cliente> consultarClientes ();
}
