import java.util.Random;

public class Sala extends Joc {
	// PROPIEDADES

	private String tipus;

	private boolean tresor ;

	private boolean monstre;

	private boolean[] arrayPortes = {false, false, false, false};

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

		// Determina de manera aleatoria si existeix o no Tresor.
		tresor = apareixer();

		// Determina de manera aleatoria si existeix o no Monstre.
		monstre = apareixer();

		// Genera un objecte de categoria Tresor.
		generarTresor();
		
		// Genera un objecte de categoria Monstre.
		generarMonstre();
		
		// Generem les possibles sortides.
		determinarPortes();
		
		explorada = false;
	}



	// Getters i Setters
	public void setExplorada(boolean explorada) {
		this.explorada = explorada;
	}

	public boolean getExplorada() {
		return this.explorada;
	}

	public String getTipus() {
		return tipus;
	}

	/**
	 * Funció que retorna si existeix un Tresor a la Sala.
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

	public boolean[] getPortes() {
		return this.arrayPortes;
	}
	
	// MÉTODOS
	/**
	 * Funció que retorna un boolean aleatori.
	 * @return
	 */
	private boolean apareixer() { 
		Random random = new Random();
		return random.nextBoolean();

	}
	
	/**
	 * Funció que genera un Monstre aleatori si el boolean == true.
	 */
	private void generarMonstre() {
		if (this.monstre) {
			monstreObj = new Monstre();
		}
	}

	/**
	 * Funció que genera un Tresor aleatori si el boolean == true.
	 */
	private void generarTresor() {
		if (this.tresor) {
			tresorObj = new Tresor();
		}
	}

	/**
	 * Funció que determina el tipus de sala aleatòriament.
	 * @return
	 */
	private int tipoSala() {
		Random num = new Random ();
		int randomInt= num.nextInt(101);
		return randomInt;

	}
	
	/**
	 * Funció que genera el valor de les portes aleatòriament.
	 */
	private void determinarPortes() {
		Random random = new Random();
		// Els valors de l'array són N, S, E, O.
		for (int i=0;i<4;i++) {
			this.arrayPortes[i] = random.nextBoolean();
		}
	}

	@Override
	public String toString() {
		return "Sala | tipus: " + tipus + ", tresor: " + tresor +  (monstreObj != null ? ", Monstre: " + monstreObj.toString() : ", Sense Monstre") + (tresorObj != null ? ", Tresor: " + tresorObj.toString() : ", Sense Tresor") + ".";
	}
	

}



