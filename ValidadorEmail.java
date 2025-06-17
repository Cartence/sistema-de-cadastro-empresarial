package cadastro;

public class ValidadorEmail {
    public static boolean ehValido(String email) {
        return email != null &&
        email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    }
}