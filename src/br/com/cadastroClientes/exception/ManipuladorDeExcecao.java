package br.com.cadastroClientes.exception;

public class ManipuladorDeExcecao {
    public static void lancamentoDeExcecao (Integer numException) throws NomeException, SobrenomeException, IdadeException, CpfException, EmailException, TelefoneException {
        switch (numException) {
            case 1:
                throw new NomeException("Campo de nome está vazio ou contêm irregularidades!");
            case 2:
                throw new SobrenomeException("Campo de sobrenome está vazio ou contêm irregularidades!");
            case 3:
                throw new IdadeException("Campo de idade está vazio ou contêm irregularidades!");
            case 4:
                throw new CpfException("Campo de cpf está vazio ou contêm irregularidades!");
            case 5:
                throw new EmailException("Campo de e-mail está vazio ou contêm irregularidades!");
            case 6:
                throw new TelefoneException("Campo de telefone está vazio ou contêm irregularidades!");
        }
    }
}
