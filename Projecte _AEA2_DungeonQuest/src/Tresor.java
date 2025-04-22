public abstract class Tresor extends Joc {
    protected String nom;
    private int valor;
    private double pes;
    protected String[] nomsTresor = {"Reliquies Dorades", "Recompenses Obscures", "Cofre de Combat"};

    public Tresor() {
        generarValorsTresor();
    }

    public int getValor() {
        return valor;
    }
    
	public void setValor(int valor) {
		this.valor = valor;
	}

    public abstract boolean getUsTresor();

    public String getNom() {
        return nom;
    }

    public double getPes() {
        return pes;
    }

    public void generarValorsTresor() {
        this.valor = generarValorAleatori(100, 3_000);
        this.pes = this.valor * 0.0075;
        
        if (!getUsTresor()) {
            this.nom = nomsTresor[generarValorAleatori(0, nomsTresor.length - 1)];
        }
    }
    
    public abstract String mostrarMissatge();
    
    @Override
    public String toString() {
        return "[nom=" + nom + ", valor=" + valor + ", pes=" + pes + ", " + mostrarMissatge() + "]";
    }


}
