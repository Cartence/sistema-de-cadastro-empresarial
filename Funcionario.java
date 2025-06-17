package cadastro;

public class Funcionario {
    private String nome;
    private String email;
    private String telefone;
    private String cargo;
    private int id; // substituindo o salário por id

    public Funcionario(String nome, String email, String telefone, String cargo, int id) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Email: %s | Telefone: %s | Cargo: %s | ID: %d",
                nome, email, telefone, cargo, id);
    }
}