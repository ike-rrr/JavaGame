import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Masmorra extends Joc {

	// Propietats
	private Monstre[] arrayMonstres = new Monstre[0];
	private Tresor[] arrayTresors = new Tresor[0];
	private Sala[][] matriuSales = new Sala[10][10];
	private Personatge jugador;
	private int nombreMonstres = 0;
	private int nombreTresors = 0;

	// Constructors
	public Masmorra(Personatge jugador) {
		// Generem array del tamany de la Masmorra per contenir els monstres i els tresors.
		this.jugador = jugador;
		crearSales();
		tamanyArrays();
		omplirMasmorra();

	}

	// Getters i Setters
	public Sala[][] getMatriuSales() {
		return matriuSales;
	}

	// Mètodes
	/**
	 * Funció que conta el nombre de monstres / tresors i assigna una dimensió a les arrays corresponents per contenir-les.
	 */
	private void tamanyArrays() {
		for (int i=0; i<this.matriuSales.length; i++) {
			for (int f=0; f<this.matriuSales[i].length; f++) {
				// asegura si n'hi ha monstre.
				if (this.matriuSales[i][f].isMonstre() == true) {
					nombreMonstres++;

				}
				// mira si n'hi ha tresor.
				if (this.matriuSales[i][f].isTresor() == true) {
					nombreTresors++;

				}
			}
		}

		this.arrayMonstres = new Monstre[nombreMonstres];
		this.arrayTresors = new Tresor[nombreTresors];

	}

	/**
	 * Funció que genera objectes Sala dintre de la matriu Masmorra.
	 */
	private void crearSales() {
		for (int i=0; i<this.matriuSales.length; i++) {
			for (int f=0; f<this.matriuSales[i].length; f++) {
				this.matriuSales[i][f] = new Sala();

			}
		}
	}

	/**
	 * Funció que ompleix les arrays de Monstres i Tresors. 
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
	 * Funció que mostra la vista de la matriu. 
	 * @param masmorra
	 */
	public void generarVista() {
		Point posicioActual =  this.jugador.getPosicio();
		for (int i=0; i<this.matriuSales.length; i++) {
			for (int f=0; f<this.matriuSales[i].length; f++) {
				if (i == posicioActual.x && f == posicioActual.y) {
					System.out.print("(&)");

				} else if (this.matriuSales[i][f].getExplorada() == true) {
					System.out.print("(*)");

				} else {
					System.out.print("(-)");

				}
			}
			System.out.println();
		}
	}

	/**
	 * Funció que mostra les opcions que té el Personatge.
	 */
	public boolean mostrarMenu() {
		generarVista();
		Scanner teclado = new Scanner(System.in);
		System.out.println("que escolleixes fer ara?");
		System.out.println("1 | Moure a una altra sala");
		System.out.println("2 | Utilitzar un tresor de l'inventari");
		System.out.println("3 | Explorar aquesta sala");
		boolean haFinalitzat = determinarAccio(demanarResposta(3));
		return haFinalitzat;
	}

	public boolean determinarAccio(int valor) {
		switch (valor) {
		case 1: {
			return mostrarSortides();

		} case 2: {
			mostrarUtils();
			break;

		} case 3: {
			explorarSala();
			break;

		}
		default:
			throw new IllegalArgumentException("Incorrecte: " + valor);
		}
		return false;
	}

	/**
	 * Funció que mostra les possibles direccions.
	 */
	public boolean mostrarSortides() {
		Point posicioActual =  this.jugador.getPosicio();
		String tipusSala = this.matriuSales[posicioActual.x][posicioActual.y].getTipus();
		System.out.println(tipusSala);
		if (!(tipusSala.equalsIgnoreCase("Normal"))) {
			generarProba(tipusSala);

		}
		
		// Agafa tots els valors possibles i els afegeix en ordre.
		boolean[] arrayDireccions = this.matriuSales[this.jugador.getPosicio().x][this.jugador.getPosicio().y].getPortes();
		int numeracio = 0;
		String[] arrayValors = {"Nort", "Sud", "Est", "Oest"};
		String[] valorsPossibles = new String[4];
		for (int i=0;i<4;i++) {
			if (arrayDireccions[i]) {
				valorsPossibles[numeracio] = arrayValors[i];
				System.out.println((numeracio + 1) + " | " + "Moure en direcció " + arrayValors[i] + ".");
				numeracio++;
			}
		}
		
		// Si malhauradament no s'ha generat ni una sola porta l'haurem de forçar.
		if (numeracio == 0) {
			int numeroAleatori = generarValorAleatori(0, 3);
			valorsPossibles[numeracio] = arrayValors[numeroAleatori];
			System.out.println((numeracio + 1) + " | " + "Moure en direcció " + arrayValors[numeroAleatori] + ".");
			arrayDireccions[numeroAleatori] = true;
		}

		boolean haFinalitzat = this.jugador.mourePersonatge(valorsPossibles[demanarResposta(numeracio) - 1]);
		return haFinalitzat;
	}

	private void generarProba(String tipus) {
		boolean exit = false;
		Scanner teclado = new Scanner(System.in);
		if (tipus.equalsIgnoreCase("Teranyina")) {
			do { 
				System.out.println("Dona un intent de sortida");
				teclado.nextLine();
				if (generarValorAleatori(1, 12) <= this.jugador.getForsa()) {
					System.out.println("Has tingut exit!!!");
					exit = true;
				} else {
					System.out.println("No has tingut la suficient força!!!");
				}
			} while (exit == false);

		} else if (tipus.equalsIgnoreCase("Pont")) {
			do {
				System.out.println("Dona un intent de sortida");
				teclado.nextLine();
				if (generarValorAleatori(1, 12) <= this.jugador.getAgilitat()) {
					System.out.println("Has tingut exit!!!");
					exit = true;
				} else {
					System.out.println("No has tingut la suficient agilitat!!!");
				}
			} while (exit == false);
		}
	}

	private void mostrarUtils() {
		this.jugador.mostrarUtils();
	}

	private void explorarSala() {
		this.jugador.explorarSala();
	}

}
