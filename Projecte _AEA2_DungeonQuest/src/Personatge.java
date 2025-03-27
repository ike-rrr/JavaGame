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
	private Tresor[] equipament;

	// Constructors
	public Personatge(String nom) {
		this.nom = nom;
		generarValorsPersonatge();

	}

	//Getters i Setters

	/**
	 * Funció que retorna la posició del Personatge
	 * @return
	 */
	public static Point getPosicio(Personatge personatge) {
		return personatge.posicio;
	}
	
	private void setPosicio(int x, int y) {
		this.posicio.x = x;
		this.posicio.y = y;
		
	}

	
	// Mètodes 
	/**
	 * Funció que utilitza l'objecte seleccionat si es que és possible
	 */
    public void utilitzarTresor (int i) {
    	Tresor objTresor = this.equipament[i];
    	int valor = this.equipament[i].getValor();
    	boolean usTresor = this.equipament[i].getUsTresor();
    	
    	// FUNCIÓN PARA USAR EL HUMO QUE NOS TELETRANSPORTA A UN LUIGAR ALEATORIO
    	if(usTresor) {
    		if(valor >= 100){
    												//HACERLO VARIABLE
    			this.setPosicio(generarValorAleatori(0, 10), generarValorAleatori(0, 10));
    			valor -= 100;
    		}else {
    			System.out.println("No hi ha fum suficient");
    		}
    	}else
    		System.out.println("Aquest tresor no té us");
    }
	

	/**
	 * Funció que assigna automàticament els valors d'una instància de 'Personatge'
	 */
	public void generarValorsPersonatge() {
		this.vida = generarValorAleatori(5, 20);
		this.atac = generarValorAleatori(1, 4);
		this.posicio.setLocation(1, 0);
		this.experiencia = 0;
		this.agilitat = generarValorAleatori(4, 11);
		this.forsa = generarValorAleatori(4, 11);
		
		// La mida de l'array és igual a la força del Personatge.
		this.equipament = new Tresor[atac];

	}

	/**
	 * Funció que mou Personatge en la posició en x i y en +-1
	 * @param direccio
	 */
	public void mourePersonatge(char direccio) {
		switch (direccio) {
		case 'N': {
			this.posicio.move(posicio.x - 1, posicio.y);
			break;

		} case 'S': {
			this.posicio.move(posicio.x + 1, posicio.y);
			break;

		} case 'E': {
			this.posicio.move(posicio.x, posicio.y + 1);
			break;

		} case 'O': {
			this.posicio.move(posicio.x + 1, posicio.y - 1);
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