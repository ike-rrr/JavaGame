public class TresorAmbUs extends Tresor {
    public TresorAmbUs() {
        super();
        this.nom = "Frasc de fum ancestral";
    }

    @Override
    public boolean getUsTresor() {
        return true;
    }

    @Override
    public String mostrarMissatge() {
        return "Genera un núvol de fum ancestral que et porta a una altre punt a l'atzar (perd valor cada vegada que s'utilitza)";
    }
    
    @Override
    public String toString() {
        return "[nom=" + getNom() + ", valor=" + getValor() + "]";
    }
}