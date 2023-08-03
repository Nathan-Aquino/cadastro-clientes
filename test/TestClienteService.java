import br.com.cadastroClientes.dao.InicializacaoDao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.services.ClienteService;
import br.com.cadastroClientes.services.generics.IGenericServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestClienteService {
    public static Cliente cliente = new Cliente("Teste", "Teste", "29","18219289031", "teste@teste.com","11944447777");;
    public IGenericServices<Cliente> service;

    @Before
    public void inicializar () {
        this.service = ClienteService.service(InicializacaoDao.clienteDao());
        this.service.salvar(this.cliente);
    }

    @Test
    public void testeSalvar () {
        Cliente cliente = this.service.consultar(this.cliente.getCpf());

        Assert.assertTrue(this.cliente.getId().equals(cliente.getId()));
    }

    @Test
    public void testeAtualizar () {
        Cliente cliente = new Cliente("Teste", "Silva", "29","18219289031", "teste@teste.com","11944447777");
        cliente.setId(Integer.parseInt(this.cliente.getId()));

        service.atualizar(cliente);

        Cliente clienteRetornado = service.consultar(cliente.getCpf());

        Assert.assertTrue(!clienteRetornado.getSobrenome().equals(this.cliente.getSobrenome()));
    }

    @Test
    public void testeConsultar () {
        Cliente clienteRetornado = service.consultar(this.cliente.getCpf());

        Assert.assertTrue(this.cliente.getId().equals(clienteRetornado.getId()));
    }

    @Test
    public void testeConsultarTodos () {
        List<Cliente> clientes = service.consultarObjetos();

        Cliente clienteEspecifico = clientes.get(0);

        Assert.assertTrue(this.cliente.getId().equals(clienteEspecifico.getId()));
    }

    @Test
    public void testeExcluir () {
        service.excluir(this.cliente.getCpf());

        List<Cliente> clientes = service.consultarObjetos();

        Assert.assertTrue(clientes.size() == 0);
    }
}
