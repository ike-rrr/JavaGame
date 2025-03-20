import java.util.Arrays;

public class Masmorra {

	// Propietats
	private Monstre[] arrayMonstres = new Monstre[0];
	private Tresor[] arrayTresors = new Tresor[0];
	private Sala[][] matriuSales = new Sala[10][10];
	private int nombreMonstres = 0;
	private int nombreTresors = 0;
	
	// Constructors
	public Masmorra() {
		// Generem array del tamany de la Masmorra per contenir els monstres i els tresors.
		crearSales();
		tamanyArrays();
		omplirMasmorra();


	}

	// Getters i Setters
	public static Sala[][] getMatriuSales(Masmorra masmorra) {
		return masmorra.matriuSales;
		
	}
	


	// Mètodes
	/**
	 * Funció que conta el nombre de monstres / tresors i assigna una dimensió a les arrays corresponents per contenir-les
	 */
	private void tamanyArrays() {
		for (int i=0; i<this.matriuSales.length; i++) {
			for (int f=0; f<this.matriuSales[i].length; f++) {
				// MIRA SI HAY MONSTER
				if (this.matriuSales[i][f].isMonstre() == true) {
					nombreMonstres++;

				}
				// MIRA SI HAY TESORO
				if (this.matriuSales[i][f].isTresor() == true) {
					nombreTresors++;

				}

			}

		}

		this.arrayMonstres = new Monstre[nombreMonstres];
		this.arrayTresors = new Tresor[nombreTresors];

	}

	/**
	 * Funció que genera objectes Sala dintre de la matriu Masmorra
	 */
	private void crearSales() {
		for (int i=0; i<this.matriuSales.length; i++) {
			for (int f=0; f<this.matriuSales[i].length; f++) {
				this.matriuSales[i][f] = new Sala();

			}

		}
		
	}

	/**
	 * Funció que ompleix les arrays de Monstres i Tresors 
	 */
	private void omplirMasmorra() {
		int contadorMonstre = 0;
		int contadorTresor = 0;
		for (int i=0; i<this.matriuSales.length; i++) {
			for (int f = 0; f<this.matriuSales[i].length; f++) {
				// Si la sala consta de monstres l'implementa a l'array de Monstres.
				if (this.matriuSales[i][f].isMonstre() == true) {
					this.arrayMonstres[contadorMonstre] = this.matriuSales[i][f].getEnemic();
					contadorMonstre++;

				}

				// Si la sala consta de tresors l'implementa a l'array de Tresors.
				if (this.matriuSales[i][f].isTresor() == true) {
					this.arrayTresors[contadorTresor] = this.matriuSales[i][f].getRecompensa();
					contadorTresor++;

				}

			}
		}
		return;
	}


	/**
	 * Funció que mostra la vista de la matriu 
	 * @param masmorra
	 */
	public static void generarVista(Masmorra masmorra, Personatge personatge) {
		for (int i=0; i<masmorra.matriuSales.length; i++) {
			for (int f=0; f<masmorra.matriuSales[i].length; f++) {
				if (i == personatge.getPosicio(personatge).x && f == personatge.getPosicio(personatge).y) {
					System.out.print("(&)");
					
				} else if (masmorra.matriuSales[i][f].getExplorada() == true) {
					System.out.print("(*)");
					
				} else {
					System.out.print("(-)");
					
				}
				

			}
			System.out.println();
		}

	}

}
