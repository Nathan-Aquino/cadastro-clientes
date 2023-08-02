package br.com.cadastroClientes.services.generics;

import br.com.cadastroClientes.dao.generics.IGenericDao;
import br.com.cadastroClientes.domain.Modelo;

import java.util.List;

public abstract class GenericServices<T extends Modelo> implements IGenericServices<T>{
    private IGenericDao<T> dao;

    public GenericServices (IGenericDao dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(T objeto) {
        dao.salvar(objeto);
    }

    @Override
    public void atualizar(T objeto) {
        dao.atualizar(objeto);
    }

    @Override
    public void excluir(String identificador) {
        dao.excluir(identificador);
    }

    @Override
    public T consultar(String identificador) {
        return dao.consultar(identificador);
    }

    @Override
    public List<T> consultarObjetos() {
        return dao.consultarObjetos();
    }
}
