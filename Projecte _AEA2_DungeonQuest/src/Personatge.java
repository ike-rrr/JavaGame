import java.awt.Point;
import java.util.ArrayList;
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
	private ArrayList<Tresor> equipament;
	private Masmorra masmorra;
	
	// Constructors
	public Personatge(String nom) {
		this.nom = nom;
		this.vida = generarValorAleatori(5, 20);
		this.atac = generarValorAleatori(1, 4);
		this.posicio.setLocation(0, 0);
		this.experiencia = 0;
		this.agilitat = generarValorAleatori(4, 11);
		this.forsa = generarValorAleatori(4, 11);
		this.masmorra = new Masmorra(this);
		
		// La mida de l'array és igual a la força del Personatge.
		this.equipament = new ArrayList();

	}

	//Getters i Setters

	/**
	 * Funció que retorna la posició del Personatge
	 * @return
	 */
	public Point getPosicio() {
		return this.posicio;
	}
	
	private void setPosicio(int x, int y) {
		this.posicio.x = x;
		this.posicio.y = y;
		
	}
	
	public ArrayList<Tresor> getEquipament() {
		return equipament;
	}

	public void setEquipament(ArrayList<Tresor> equipament) {
		this.equipament = equipament;
	}

	public int getVida() {
		return vida;
	}

	public int getAgilitat() {
		return agilitat;
	}

	public int getForsa() {
		return forsa;
	}

	// Mètodes 
	/**
	 * Funció que utilitza l'objecte seleccionat si es que és possible.
	 */
    public void utilitzarTresor (int i) {
    	Tresor objTresor = this.equipament.get(i);
    	int valor = this.equipament.get(i).getValor();
    	boolean usTresor = this.equipament.get(i).getUsTresor();
    	
    	// si l'objecte té un us i encara té un valor superior a 100.
    	if(usTresor) {
    		if(valor >= 100){
    			//HACERLO VARIABLE
    			this.setPosicio(generarValorAleatori(0, this.masmorra.getMatriuSales()[0].length), generarValorAleatori(0, this.masmorra.getMatriuSales()[0].length));
    			valor -= 100;
    		}else {
    			System.out.println("No hi ha fum suficient");
    		}
    	}else
    		System.out.println("Aquest tresor no té us");
    }

	/**
	 * Funció que mou Personatge en la posició en x i y en +-1.
	 * @param direccio
	 */
	public boolean mourePersonatge(String direccio) {
		switch (direccio) {
		case "Nort": {
			if (estaFora((this.posicio.y - 1), this.masmorra.getMatriuSales().length)) {
				System.out.println("Has sortit de la Masmorra!!");
				return true;
			} else {
				this.posicio.move(posicio.y - 1, posicio.x);
				return false;
			}

		} case "Sud": {
			if (estaFora((this.posicio.y + 1), this.masmorra.getMatriuSales().length)) {
				System.out.println("Has sortit de la Masmorra!!");
				return true;
			} else {
				this.posicio.move(posicio.y + 1, posicio.x);
				return false;
			}

		} case "Est": {
			if (estaFora((this.posicio.x + 1), this.masmorra.getMatriuSales()[0].length)) {
				System.out.println("Has sortit de la Masmorra!!");
				return true;
			} else {
				this.posicio.move(posicio.y, posicio.x + 1);
				return false;
			}
			
		} case "Oest": {
			if (estaFora((this.posicio.x - 1), this.masmorra.getMatriuSales()[0].length)) {
				System.out.println("Has sortit de la Masmorra!!");
				return true;
			} else {
				this.posicio.move(posicio.y, posicio.x - 1);
				return false;
			}
		}
		default:
			throw new IllegalArgumentException("Incorrecte: " + direccio);

		}
	}

	/**
	 * Funció que comproba si una sala ha sigut explorada i l'assigna.
	 */
	public void explorarSala() {
		Sala salaActual = this.masmorra.getMatriuSales()[this.posicio.x][this.posicio.y];
		salaActual.setExplorada(true);
		System.out.println(salaActual);
		if (salaActual.isTresor()) {
			this.equipament.add(salaActual.getRecompensa());
		}
		
		if (salaActual.isMonstre()) {
			situacioCombat(salaActual);
		}
		
	}
	
	/**
	 * Funció que controla les accions de combat fins que s'elimina l'enemic o es fugeix.
	 * @param sala
	 */
	private void situacioCombat(Sala sala) {
		int resposta = 0;
		while (sala.getEnemic().getVida() > 0 && resposta != 1) {
			System.out.println("Com vols actuar ara?");
			System.out.println("1 | Fugir.");
			System.out.println("2 | Lluitar.");
			resposta = demanarResposta(2);
			aplicarAccioCombat(resposta);
		}
	}
	
	private void aplicarAccioCombat(int decisio) {
		Monstre monstre = this.masmorra.getMatriuSales()[this.posicio.x][this.posicio.y].getEnemic();
		switch (decisio) {
		case 1: {
			System.out.println("Has escollit fugir.");
			this.vida -= monstre.getPenalitzacio();
			if (this.vida < 0) {
				System.out.println("Has mort en combat.");
			} else {
				this.masmorra.mostrarSortides();
			}
			break;
			 
		} case 2: {
			System.out.println("Has escollit lluitar.");
			monstre.setVida(monstre.getVida() - generarValorAleatori(1, this.atac));
			System.out.println(monstre);
			if (monstre.getVida() > 0) {
				System.out.println("El monstre contraataca!");
				this.vida -= 1;
			}
			break;
		}
		
		default:
			throw new IllegalArgumentException("Incorrecte: " + decisio);
		}
	}
	
	public void mostrarUtils() {
		ArrayList<Tresor> inventari = this.equipament;
		int numeracio = 1;
		for (Tresor tresor : inventari) {
			if (tresor.getUsTresor()) {
				System.out.println(numeracio + " | " + tresor.getNom());
				numeracio++;
			}
		}
		// Si existeix algun objecte amb utilitat més enllá del seu valor.
		if (numeracio != 1) {
			demanarResposta(numeracio);
			this.utilitzarTresor(numeracio);
		} else {
			System.out.println("No disposes de tresors amb utilitats activables.");
		}
	}

	@Override
	public String toString() {
		return "nom:" + nom + ", vida:" + vida + ", atac:" + atac + ", experiencia:" + experiencia
				+ ", agilitat:" + agilitat + ", forsa:" + forsa + ", posició:" + posicio  + ".";
	}	
}