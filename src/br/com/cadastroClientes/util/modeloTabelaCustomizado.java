package br.com.cadastroClientes.util;

import javax.swing.table.DefaultTableModel;

public class modeloTabelaCustomizado extends DefaultTableModel {

    public modeloTabelaCustomizado (Object[][] dados, Object[] nomeColunas) {
        super(dados, nomeColunas);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
