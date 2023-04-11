package br.com.cadastroClientes.view;

import br.com.cadastroClientes.dao.ClienteDao;
import br.com.cadastroClientes.dao.InicializacaoDao;
import br.com.cadastroClientes.domain.Cliente;
import br.com.cadastroClientes.exception.*;

import javax.swing.*;

public class FormularioComponente extends JComponent {

    private GroupLayout gpLayout;
    private TabelaComponente tabela;
    public JLabel[] labels;
    public JTextField[] textFields;

    public  FormularioComponente (TabelaComponente tabela) {

        this.tabela = tabela;

        this.labels = new JLabel[]{
                new JLabel("Nome"),
                new JLabel("Sobrenome"),
                new JLabel("Idade"),
                new JLabel("CPF"),
                new JLabel("E-mail"),
                new JLabel("Telefone")
        };

        this.textFields = new JTextField[]{
                new JTextField(),
                new JTextField(),
                new JTextField(),
                new JTextField(),
                new JTextField(),
                new JTextField()
        };

        this.gpLayout = new GroupLayout(this);

        setLayout(this.gpLayout);

        this.gerarLayoutHorizontal();
        this.gerarLayoutVertical();

        setVisible(true);
    }

    private void gerarLayoutHorizontal () {
        GroupLayout.SequentialGroup grupoHorizontal = this.gpLayout.createSequentialGroup();

        GroupLayout.Group grupoParaleloLabel = this.gpLayout.createParallelGroup();
        for (int i = 0; i < this.labels.length; i++) {
            grupoParaleloLabel.addComponent(this.labels[i]);
        }
        grupoHorizontal.addGroup(grupoParaleloLabel);

        grupoHorizontal.addGap(20);

        GroupLayout.Group grupoParaleloFields = this.gpLayout.createParallelGroup();
        for (int k = 0; k < this.textFields.length; k++) {
            grupoParaleloFields.addComponent(this.textFields[k], GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE);
        }
        grupoHorizontal.addGroup(grupoParaleloFields);

        gpLayout.setHorizontalGroup(grupoHorizontal);
    }

    private void gerarLayoutVertical () {
        GroupLayout.SequentialGroup grupoVertical = this.gpLayout.createSequentialGroup();

        for (int z = 0; z < this.labels.length; z++) {
            GroupLayout.Group grupoParalelo = this.gpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);
            grupoParalelo.addComponent(this.labels[z]);
            grupoParalelo.addComponent(this.textFields[z], GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE);

            grupoVertical.addGroup(grupoParalelo);

            if (z != 5) {
               grupoVertical.addGap(20);
            }
        }

        gpLayout.setVerticalGroup(grupoVertical);
    }

    public void salvarCliente(){
        Cliente cliente = new Cliente(
                this.textFields[0].getText(),
                this.textFields[1].getText(),
                Integer.valueOf(this.textFields[2].getText()),
                this.textFields[3].getText(),
                this.textFields[4].getText(),
                this.textFields[5].getText()
        );

        ClienteDao dao = InicializacaoDao.clienteDao();

        try {
            dao.salvar(cliente);
            this.limpaCampos();
            this.tabela.recebeClientes();
        } catch (SobrenomeException | TelefoneException | IdadeException | CpfException | NomeException | EmailException  ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void limpaCampos () {
        for (int x = 0; x < this.textFields.length; x++) {
            this.textFields[x].setText("");
        }
    }
}
