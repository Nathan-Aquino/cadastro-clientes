import br.com.cadastroClientes.dao.InicializacaoDao;
import br.com.cadastroClientes.view.TelaPrincipal;

public class App {
    public static void main(String[] args) {
        InicializacaoDao.clienteDao();
        new TelaPrincipal();
    }
}
