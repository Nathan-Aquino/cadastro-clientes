package br.com.cadastroClientes.dao.generics;

import br.com.cadastroClientes.domain.Modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericDao<T extends Modelo> implements IGenericDao<T>{
    public Map<String, T> objetos;

    public GenericDao () {
        this.objetos = new HashMap<>();
    }

    @Override
    public void salvar (T objeto) {
        if (!this.objetos.containsKey(objeto.getId())) {
            objetos.put(objeto.getId(), objeto);
        } else {
            this.atualizar(objeto);
        }
    }

    @Override
    public void atualizar (T objeto) {
        objetos.replace(objeto.getId(), objeto);
    }

    @Override
    public void excluir (String identificador) {
        if (objetos.containsKey(identificador)) {
            objetos.remove(identificador);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public T consultar (String identificador) {
        if (objetos.containsKey(identificador)) {
            return objetos.get(identificador);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public List<T> consultarObjetos () {
        List<T> objetos = new ArrayList<T>();
        for (Map.Entry<String, T> objeto : this.objetos.entrySet()) {
            objetos.add(objeto.getValue());
        }
        return objetos;
    }
}
