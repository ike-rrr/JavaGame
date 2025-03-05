
import java.util.Random;

public class Monstre {

    // PROPIETATS

    private String nom;

    private int vida;

    private int penalitzacio;

    // ARRAY AMB NOMS GENERATS 

      String[] dndNames = {
                "Aelar", "Barak", "Cindel", "Draegor", "Elira", "Fendral", "Garrick", "Halessa", 
                "Ithrin", "Jareth", "Kellian", "Lirael", "Merrik", "Nimriel", "Orrin", "Phaedra", 
                "Quenlan", "Roderic", "Sylas", "Talyra", "Ulfgar", "Varel", "Wrenna", "Xerxes", 
                "Ysolde", "Zethar", "Balin", "Caelen", "Daphne", "Eryndor", "Faelan", "Galen", 
                "Hadria", "Ilvani", "Jorik", "Kara", "Lirien", "Morrin", "Norrak", "Orla", 
                "Perrin", "Rhiannon"
            };


    // CONSTRUCTORS

    Monstre(int vida){

        // GENERAR NOM DE MONSTRE ALEATORI
        Random rand = new Random();
        int index = rand.nextInt(dndNames.length);
        nom = dndNames[index];

        this.vida = vida;

        // GENERAR VALOR D'ATAC ALEATORI
        penalitzacio = rand.nextInt(4);

    }
    // MÈTODES

    public int penalitzar() {
    	
        return penalitzacio;
    }

    // TO STRING

    public String toString() {
        return nom + " - " + vida;
    }



} 

