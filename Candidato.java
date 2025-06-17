package cadastro;

public class Candidato extends Pessoa {
    private String areaDeInteresse;
    private String curriculo;
    
    public Candidato(String nome, String email, String telefone, String areaDeInteresse, String curriculo) {
        super(nome, email, telefone);
        this.areaDeInteresse = areaDeInteresse;
        this.curriculo = curriculo;
    }
    
    public String getAreaDeInteresse() {
        return areaDeInteresse;
    }
    
    public void setAreaDeInteresse(String areaDeInteresse) {
        this.areaDeInteresse = areaDeInteresse;
    }
    
    public String getCurriculo() {
        return curriculo;
    }
    
    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }
    
    public String toString() {
        return super.toString() + ", Área de Interesse: " + areaDeInteresse + ", Currículo: " + curriculo;
     }
}