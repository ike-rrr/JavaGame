import java.util.Random;

public class Monstre {
    private String nom;
    private int vida;
    private int penalitzacio;
    String[] dndNames = {
        "Aelar", "Barak", "Cindel", "Draegor", "Elira", "Fendral", "Garrick", "Halessa", 
        "Ithrin", "Jareth", "Kellian", "Lirael", "Merrik", "Nimriel", "Orrin", "Phaedra", 
        "Quenlan", "Roderic", "Sylas", "Talyra", "Ulfgar", "Varel", "Wrenna", "Xerxes", 
        "Ysolde", "Zethar", "Balin", "Caelen", "Daphne", "Eryndor", "Faelan", "Galen", 
        "Hadria", "Ilvani", "Jorik", "Kara", "Lirien", "Morrin", "Norrak", "Orla", 
        "Perrin", "Rhiannon", "Rathalos", "Rathian"
    };

    Monstre(int vida){
        Random rand = new Random();
        int index = rand.nextInt(dndNames.length);
        nom = dndNames[index];
        this.vida = vida;
        penalitzacio = rand.nextInt(4);
    }

    public int penalitzar() {
        return penalitzacio;
    }

    public String toString() {
        return nom + " - " + vida;
    }
    
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