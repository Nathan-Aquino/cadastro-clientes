package br.com.cadastroClientes.dao.generics;

import java.util.List;

public interface IGenericDao<T> {
    public void salvar (T objeto);
    public void atualizar (T objeto);
    public void excluir (String identificador);
    public T consultar (String identificador);
    public List<T> consultarObjetos ();
}
