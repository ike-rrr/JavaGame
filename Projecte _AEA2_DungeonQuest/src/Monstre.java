
import java.util.Random;

public class Monstre extends Joc {

    // PROPIETATS

    private String nom;

    private int vida;

    private int penalitzacio;

    // ARRAY AMB NOMS GENERATS 

      String[] arrayNoms = {
                "Aelar", "Barak", "Cindel", "Draegor", "Elira", "Fendral", "Garrick", "Halessa", 
                "Ithrin", "Jareth", "Kellian", "Lirael", "Merrik", "Nimriel", "Orrin", "Phaedra", 
                "Quenlan", "Roderic", "Sylas", "Talyra", "Ulfgar", "Varel", "Wrenna", "Xerxes", 
                "Ysolde", "Zethar", "Balin", "Caelen", "Daphne", "Eryndor", "Faelan", "Galen", 
                "Hadria", "Ilvani", "Jorik", "Kara", "Lirien", "Morrin", "Norrak", "Orla", 
                "Perrin", "Rhiannon"
            };


    // CONSTRUCTORS

    Monstre(){

        // GENERAR NOM DE MONSTRE ALEATORI
        Random rand = new Random();
        int index = rand.nextInt(arrayNoms.length);
        nom = arrayNoms[index];

        this.vida = generarValorAleatori(5, 20);

        // GENERAR VALOR D'ATAC ALEATORI
        penalitzacio = rand.nextInt(4);

    }
    // MÈTODES

    // TO STRING

    public String toString() {
        return nom + " - " + vida;
    }
    
    // GETTERS I SETTERS
    
	public String getNom() {
		return nom;
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPenalitzacio() {
		return penalitzacio;
	}

	public void setPenalitzacio(int penalitzacio) {
		this.penalitzacio = penalitzacio;
	}
} 