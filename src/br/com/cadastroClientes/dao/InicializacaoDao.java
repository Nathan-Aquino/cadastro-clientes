package br.com.cadastroClientes.dao;

public class InicializacaoDao {
    private static ClienteDao dao;

    private InicializacaoDao () {
    }

    public static ClienteDao clienteDao () {
        if (dao != null) {
            return dao;
        } else {
            dao = new ClienteDao();
            return dao;
        }
    }
}
