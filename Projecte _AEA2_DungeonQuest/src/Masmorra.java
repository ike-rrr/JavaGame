
public class Masmorra extends Joc {

	// Propietats
	private Monstre[] arrayMonstres = new Monstre[0];
	private Tresor[] arrayTresors = new Tresor[0];
	private Sala[][] matriuSales = new Sala[10][10];
	private int nombreMonstres = 0;
	private int nombreTresors = 0;
	// Constructors
	public Masmorra(Monstre[] arrayMonstres, Tresor[] arrayTresors) {
		// Generem array del tamany de la Masmorra per contenir els monstres i els tresors.
		tamanyArrays();
		omplirMasmorra();

			
	}
	
	// Getters i Setters
	
	
	// Mètodes
	/**
	 * Funció que conta el nombre de monstres / tresors i assigna una dimensió a les arrays corresponents per contenir-les
	 */
	private void tamanyArrays() {
		for (int i=0; i<matriuSales.length; i++) {
			for (int f=0; f<matriuSales[i].length; f++) {
				if (matriuSales[i][f].getMonstres() == true) {
					nombreMonstres++;
					
				}
				
				if (matriuSales[i][f].getTresors() == true) {
					nombreTresors++;
					
				}
				
			}
			
		}

		arrayMonstres = new Monstre[nombreMonstres];
		arrayTresors = new Tresor[nombreTresors];
		
	}
	
	/**
	 * Funció que ompleix les arrays de Monstres i Tresors 
	 */
	private void omplirMasmorra() {
		int contadorMonstre = 0;
		int contadorTresor = 0;
		for (int i=0; i<matriuSales.length; i++) {
			for (int f=0; f<matriuSales[i].length; f++) {
				// Si la sala consta de monstres l'implementa a l'array de Monstres.
				if (matriuSales[i][f].getMonstres() == true) {
					arrayMonstres[contadorMonstre] = matriuSales[i][f].getEnemic();
					contadorMonstre++;
					
				} else if (matriuSales[i][f] == ' ') {
					
					
				}
				
				// Si la sala consta de tresors l'implementa a l'array de Tresors.
				if (matriuSales[i][f].getTresors() == true) {
					arrayTresors[contadorTresor] = matriuSales[i][f].getRecompensa();
					contadorTresor++;
					
				}
				
			}
		
		}
		
	}
	
	public static void generarVista(Masmorra masmorra) {
		for (int i=0; i<masmorra.matriuSales.length; i++) {
			for (int f=0; f<masmorra.matriuSales[i].length; f++) {
				if (masmorra.matriuSales[i][f].) {
					
					
				}
		
			}
			
		}
		
	}
	
}
