package br.com.cadastroClientes.dao;

public class InicializacaoDao {
    private static ClienteDao dao;

    public InicializacaoDao () {
        this.dao = new ClienteDao();
    }

    public static ClienteDao clienteDao () {
        return dao;
    }
}
