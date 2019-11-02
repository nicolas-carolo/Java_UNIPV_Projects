public class Veicolo {
    private String nome;
    private int nCilindri;
    private Persona proprietario;

    public Veicolo(String nome, int nCilindri, Persona proprietario) {
        this.nome = nome;
        this.nCilindri = nCilindri;
        this.proprietario = proprietario;
    }

    public String getNome() {
        return nome;
    }

    public int getnCilindri() {
        return nCilindri;
    }

    public Persona getProprietario() {
        return proprietario;
    }

    public boolean equals(Veicolo v){
        if (this.nome.equals(v.nome) && this.nCilindri == v.nCilindri && this.proprietario.getNome().equals(v.proprietario.getNome())) {
            return true;
        }

        return false;
    }
}
