public class Tresor extends Joc {
	// Propietats
	private String nom;
	private int valor;
	private double pes;
	private String[] nomsTresor = {"Reliquies Dorades", "Recompenses Obscures", "Cofre de Combat"};
	
	// Constructors
	public Tresor() {
		generarValorsTresor();
		
	}
	
	// Getters i Setters
	public String[] getNomsTresor() {
		return nomsTresor;
	}
	
	
	// Mètodes
	
	/**
	 * Funció que assigna automàticament els valors d'una instància de 'Tresor'
	 */
	public void generarValorsTresor() {
		String [] array = this.nomsTresor;
		// El nom és una selecció aleatoria d'un valor de l'array de noms.
		this.nom = array[generarValorAleatori(0, array.length - 1)];
		this.valor = generarValorAleatori(100, 3_000);
		// Cada moneda d'or multiplicada pel seu pes sense tenir en compte el cofre.
		this.pes = this.valor * 0.0075;
		
	}

	@Override
	public String toString() {
		return "[nom=" + nom + ", valor=" + valor + ", pes=" + pes + "]";
	}
	
	
	
	
	
}
