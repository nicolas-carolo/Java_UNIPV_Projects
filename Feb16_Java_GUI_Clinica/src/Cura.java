public class Cura {
    private String cognome;
    private String nome;
    private Patologia patologia;
    private Struttura struttura;
    private int giorno;
    private int ora;
    private Fisioterapista fisioterapista;

    public Cura(String cognome, String nome, Patologia patologia, Struttura struttura, int giorno, int ora, Fisioterapista fisioterapista) {
        this.cognome = cognome;
        this.nome = nome;
        this.patologia = patologia;
        this.struttura = struttura;
        this.giorno = giorno;
        this.ora = ora;
        this.fisioterapista = fisioterapista;
    }

    public String toString(){
        return "cognome e nome: " + cognome + " " + nome + "\npatologia: " + patologia.getTipoPatologia() + "\nstruttura: "
                + struttura.getTipoStruttura() + "\ngiorno: " + giorno + "\norario: " + ora + "-" + (ora + 1)
                + "\nfisioterapista: " + fisioterapista.getCognome() + " " + fisioterapista.getNome();
    }

    public String infoPaziente() {
        return "paziente: " + cognome + " " + nome + "\n\tpatologia: " + patologia;
    }
}
