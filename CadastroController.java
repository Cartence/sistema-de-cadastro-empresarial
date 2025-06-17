package cadastro;

import cadastro.Candidato;
import cadastro.Funcionario;
import cadastro.ValidadorEmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroController {
    private List<Candidato> candidatos = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            System.out.println("\nSeja bem-vindo(a) ao cadastro empresarial.");
            System.out.print("Você é funcionário da empresa? (s/n ou 'x' para sair): ");
            String resposta = sc.nextLine().trim().toLowerCase();

            switch (resposta) {
                case "s":
                    cadastroFuncionario();
                    break;
                case "n":
                    cadastrarCandidato();
                    break;
                case "x":
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite 's', 'n' ou 'x'.");
            }

            exibirTodos();
        }
    }

    private void cadastrarCandidato() {
        System.out.println("\n--- Cadastro de Candidato ---");

        String nome = lerTexto("Nome: ");
        String email = lerEmail();
        String telefone = lerTexto("Telefone: ");
        String area = lerTexto("Área de interesse: ");
        String curriculo = lerTexto("Link para o currículo: ");

        Candidato candidato = new Candidato(nome, email, telefone, area, curriculo);
        candidatos.add(candidato);

        System.out.println("\nCandidato cadastrado com sucesso!");
    }

    private void cadastroFuncionario() {
        System.out.println("\n--- Cadastro de Funcionário ---");

        String nome = lerTexto("Nome: ");
        String email = lerEmail();
        String telefone = lerTexto("Telefone: ");
        String cargo = lerTexto("Cargo: ");
        int id = lerInt("ID do funcionário: ");

        Funcionario funcionario = new Funcionario(nome, email, telefone, cargo, id);
        funcionarios.add(funcionario);

        System.out.println("\nFuncionário logado com sucesso!");
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine().trim();
    }

    private int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextInt()) {
            System.out.print("ID inválido. " + mensagem);
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine(); // consome o enter
        return valor;
    }

    private String lerEmail() {
        String email;
        while (true) {
            email = lerTexto("Email: ");
            if (ValidadorEmail.ehValido(email)) {
                return email;
            }
            System.out.println("Email inválido. Tente novamente.");
        }
    }

    private void exibirTodos() {
        System.out.println("\n--- Lista de Candidatos ---");
        for (Candidato c : candidatos) {
            System.out.println(c);
        }

        System.out.println("\n--- Lista de Funcionários ---");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }
}