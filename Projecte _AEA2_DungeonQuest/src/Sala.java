import java.util.Random;

public class Sala extends Joc {
	// PROPIEDADES

	private String tipus;

	private boolean tresor ;

	private boolean monstre;

	private int numPortes;

	private boolean explorada;

	private Monstre monstreObj;
	
	private Tresor tresorObj;

	// CONSTRUCTORES

	public Sala(){

		if(tipoSala() <= 70) {
			tipus = "Normal";
		}else if (tipoSala() <= 85) {
			tipus = "Pont";

		}else {
			tipus = "Teranyna";

		}

		// Determina de manera aleatoria si existeix o no Tresor
		tresor = apareixer();

		// Determina de manera aleatoria si existeix o no Monstre
		monstre = apareixer();

		// Genera un objecte de categoria Tresor
		generarTresor();
		
		// Genera un objecte de categoria Monstre
		generarMonstre();
		
		explorada = false;
	}



	// Getters i Setters
	public void setExplorada(boolean explorada) {
		this.explorada = explorada;
	}

	public boolean getExplorada() {
		return this.explorada;
	}


	// MÉTODOS

	/**
	 * Funció que retorna un boolean aleatori
	 * @return
	 */
	private boolean apareixer() {
		Random rand = new Random ();
		boolean randomBoolean = rand.nextBoolean();
		return randomBoolean;

	}
	
	/**
	 * Funció que retorna si existeix un Tresor a la Sala
	 * @return tresor
	 */
	public boolean isTresor() {
		return tresor;
	}
	
	/**
	 * Funció que retorna l'objecte Tresor
	 * @return
	 */
	public Tresor getRecompensa() {
		return this.tresorObj;
	}

	/**
	 * Funció que retorna si existeix un Monstre a la Sala
	 * @return monstre 
	 */
	public boolean isMonstre() {
		return monstre;
	}
	
	/**
	 * Funció que retorna l'objecte Monstre
	 * @return
	 */
	public Monstre getEnemic() {
		return this.monstreObj;
	}
	
	/**
	 * Funció que genera un Monstre aleatori si el boolean == true
	 */
	private void generarMonstre() {
		if (this.monstre) {
			monstreObj = new Monstre(generarValorAleatori(5, 20));
		}
	}

	/**
	 * Funció que genera un Tresor aleatori si el boolean == true
	 */
	private void generarTresor() {
		if (this.tresor) {
			tresorObj = new Tresor();
		}
	}

	/**
	 * Funció que determina el tipus de sala aleatoriament
	 * @return
	 */
	private int tipoSala() {
		Random num = new Random ();
		int randomInt= num.nextInt(101);
		return randomInt;

	}

	@Override
	public String toString() {
		return "Sala [tipus= " + tipus + ", tresor= " + tresor + ", monstre= " + monstre + ", numPortes= " + numPortes
				+ ", explorada= " + explorada +  (monstreObj != null ? ", Monstre= " + monstreObj.toString() : ", Sense Monstre") + "]";
	}
	

}
