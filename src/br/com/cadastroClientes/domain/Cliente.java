package br.com.cadastroClientes.domain;

import br.com.cadastroClientes.util.GeradorDeId;

public class Cliente implements Modelo{
    private Integer id;
    private String nome;
    private String sobrenome;
    private String idade;
    private String cpf;
    private String email;
    private String telefone;

    public Cliente (String nome, String sobrenome, String idade, String cpf, String email, String telefone) {
        this.id = GeradorDeId.gerar(nome,sobrenome);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public String getId() {
        return this.id.toString();
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getIdade() {
        return idade;
    }


    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
