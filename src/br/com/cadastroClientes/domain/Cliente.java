package br.com.cadastroClientes.domain;

public class Cliente {
    private String nome;
    private String sobrenome;
    private String idade;
    private String cpf;
    private String email;
    private String telefone;

    public Cliente (String nome, String sobrenome, String idade, String cpf, String email, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
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
}
