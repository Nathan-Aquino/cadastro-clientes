package br.com.cadastroClientes.util;
import br.com.cadastroClientes.domain.Cliente;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificacao {

    public static Boolean verificaNome (String nome) {
        if (nome.isEmpty()) {
            return false;
        }

        if (nome.contains(" ")) {
            return false;
        }

        if (nome.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }

    public static Boolean verificaSobrenome (String sobrenome) {
        if (sobrenome.isEmpty()) {
            return false;
        }

        if (sobrenome.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }

    public static Boolean verificaIdade (Integer idade) {
        if (idade >= 16) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean verificaTelefone (String telefone) {
        if (telefone.length() != 11) {
            return false;
        }

        if (!telefone.matches("^\\d{2}\\d{8,9}$")) {
            return false;
        }

        for (int i = 0; i < telefone.length() - 4; i++) {
            char c = telefone.charAt(i);
            if (c == telefone.charAt(i + 1) && c == telefone.charAt(i + 2)
                    && c == telefone.charAt(i + 3) && c == telefone.charAt(i + 4)) {
                return false;
            }
        }

        return true;
    }

    public static Boolean verificaEmail (String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        String regex = "^[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static Boolean verificaCpf (String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }

        // Verifica os dígitos verificadores
        int digito1 = calcularDigitoVerificador(cpf.substring(0, 9), 10);
        int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1, 11);
        return (cpf.charAt(9) - '0' == digito1) && (cpf.charAt(10) - '0' == digito2);
    }

    private static int calcularDigitoVerificador(String str, int peso) {
        int soma = 0;
        for (int i = 0; i < str.length(); i++) {
            soma += (str.charAt(i) - '0') * peso--;
        }

        int resto = soma % 11;
        if (resto < 2) {
            return 0;
        } else {
            return 11 - resto;
        }
    }

    public static Integer verificaCliente (Cliente cliente) {
        Boolean nome = verificaNome(cliente.getNome());
        Boolean sobrenome = verificaSobrenome(cliente.getSobrenome());
        Boolean idade = verificaIdade(cliente.getIdade());
        Boolean cpf = verificaCpf(cliente.getCpf());
        Boolean email = verificaEmail(cliente.getEmail());
        Boolean telefone = verificaTelefone(cliente.getTelefone());

        if (!nome) {
            return 1;
        }

        if (!sobrenome) {
            return 2;
        }

        if (!idade) {
            return 3;
        }

        if (!cpf) {
            return 4;
        }

        if (!email) {
            return 5;
        }

        if (!telefone) {
            return 6;
        }

        return 0;
    }
}
