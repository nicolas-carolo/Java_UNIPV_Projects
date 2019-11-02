public class Persona {
    private String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Persona p){
        return this.nome.equals(p.nome);
    }

    public String toString(){
        return getNome();
    }
}
