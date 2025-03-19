import java.util.Random;

public class Sala {
	// PROPIEDADES

	private String tipus;

	private boolean tresor ;

	private boolean monstre;

	private int numPortes;

	private boolean explorada;

	private Monstre monstreObj;


	// CONSTRUCTORES

	Sala(){

		if(tipoSala() <= 70) {
			tipus = "Normal";
		}else if (tipoSala() <= 85) {
			tipus = "Pont";

		}else {
			tipus = "Teranyna";

		}

		tresor = apareixer();

		monstre = apareixer();

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

	// Booleano que hace si o no aleatorio
	private boolean apareixer() {
		Random rand = new Random ();
		boolean randomBoolean = rand.nextBoolean();
		return randomBoolean;

	}

	public boolean isTresor() {
		return tresor;
	}

	public void setTresor(boolean tresor) {
		this.tresor = tresor;
	}

	public boolean isMonstre() {
		return monstre;
	}

	public void setMonstre(boolean monstre) {
		this.monstre = monstre;
	}



	// Crea un número del 0 al 100 que determinará que tipo de sala es
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