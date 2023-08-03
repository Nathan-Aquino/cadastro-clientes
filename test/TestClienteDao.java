import br.com.cadastroClientes.dao.InicializacaoDao;
import br.com.cadastroClientes.dao.generics.IGenericDao;
import br.com.cadastroClientes.domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestClienteDao {
    public static Cliente cliente = new Cliente("Teste", "Teste", "29","18219289031", "teste@teste.com","11944447777");;
    public IGenericDao<Cliente> dao;

    @Before
    public void inicializar () {
        this.dao = InicializacaoDao.clienteDao();
        this.dao.salvar(this.cliente);
    }

    @Test
    public void testeSalvar () {
        Cliente cliente = this.dao.consultar(this.cliente.getId());

        Assert.assertTrue(this.cliente.getId().equals(cliente.getId()));
    }

    @Test
    public void testeAtualizar () {
        Cliente cliente = new Cliente("Teste", "Silva", "29","18219289031", "teste@teste.com","11944447777");
        cliente.setId(Integer.parseInt(this.cliente.getId()));

        dao.atualizar(cliente);

        Cliente clienteRetornado = dao.consultar(cliente.getId());

        Assert.assertTrue(!clienteRetornado.getSobrenome().equals(this.cliente.getSobrenome()));
    }

    @Test
    public void testeConsultar () {
        Cliente clienteRetornado = dao.consultar(this.cliente.getId());

        Assert.assertTrue(this.cliente.getId().equals(clienteRetornado.getId()));
    }

    @Test
    public void testeConsultarTodos () {
        List<Cliente> clientes = dao.consultarObjetos();

        Cliente clienteEspecifico = clientes.get(0);

        Assert.assertTrue(this.cliente.getId().equals(clienteEspecifico.getId()));
    }

    @Test
    public void testeExcluir () {
        dao.excluir(this.cliente.getId());

        List<Cliente> clientes = dao.consultarObjetos();

        Assert.assertTrue(clientes.size() == 0);
    }
}
