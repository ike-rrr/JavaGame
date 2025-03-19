import java.awt.Point;
import java.util.Arrays;

public class Personatge extends Joc {
	// Propietats
	private String nom;
	private int vida;
	private int atac;
	private int experiencia;
	private int agilitat;
	private int forsa;
	private Point posicio = new Point();
	private String[] equipament;
	private int[][] matriuRandom = new int[4][4];

	// Constructors
	public Personatge(String nom) {
		this.nom = nom;
		generarValorsPersonatge();

	}

	//Getters i Setters

	// Mètodes 

	/**
	 * Funció que assigna automàticament els valors d'una instància de 'Personatge'
	 */
	public void generarValorsPersonatge() {
		this.vida = generarValorAleatori(5, 20);
		this.atac = generarValorAleatori(1, 4);
		this.posicio.setLocation(0, 0);
		this.experiencia = 0;
		this.agilitat = generarValorAleatori(4, 11);
		this.forsa = generarValorAleatori(4, 11);
		// La mida de l'array és igual a la força del Personatge.
		this.equipament = new String[atac];

	}

	/**
	 * Funció que canvia la posició en x i y segons la direcció donada i si es pot
	 * @param direccio
	 */
	public void mourePersonatge(char direccio) {
		switch (direccio) {
		case 'N': {
			// Comprobem que si restem o sumem 1 a la posició no sortim de la matriu.
			if (!estaFora(posicio.y, this.matriuRandom.length)) {
				this.posicio.move(0, posicio.y + 1);

			}
			break;

		} case 'S': {
			if (!estaFora(posicio.y, this.matriuRandom.length)) {
				this.posicio.move(0, posicio.y - 1);

			}
			break;

		} case 'E': {
			if (!estaFora(posicio.x, this.matriuRandom[0].length)) {
				this.posicio.move(posicio.x + 1, 0);

			}
			break;

		} case 'O': {
			if (!estaFora(posicio.x, this.matriuRandom[0].length)) {
				this.posicio.move(posicio.x - 1, 0);

			}
			break;

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + direccio);

		}
	}

	/**
	 * Funció que comproba si una sala ha sigut explorada i l'assigna
	 */
	public void explorarSala() {


	}

	@Override
	public String toString() {
		return "[nom=" + nom + ", vida=" + vida + ", atac=" + atac + ", experiencia=" + experiencia
				+ ", agilitat=" + agilitat + ", forsa=" + forsa + ", posició=" + posicio + ", equipament="
				+ Arrays.toString(equipament) + "]";
	}	
}