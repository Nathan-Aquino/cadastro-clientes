package br.com.cadastroClientes.util;

import br.com.cadastroClientes.domain.Cliente;

import java.util.List;

public class Transformacao {
    public static String[][] listaParaMatriz (List<Cliente> clientes) {
        String clientesM[][] = new String[clientes.size()][4];
        for (int i = 0; i < clientes.size(); i++) {
            clientesM[i] = new String[]{
                    clientes.get(i).getCpf(),
                    clientes.get(i).getNome() + " " + clientes.get(i).getSobrenome(),
                    clientes.get(i).getEmail(),
                    clientes.get(i).getTelefone()
            };
        }

        return clientesM;
    }
}
