public class Tresor extends Joc {
    // Propietats
    private String nom;
    private int valor;
    private double pes;
    private String[] nomsTresor = {"Reliquies Dorades", "Recompenses Obscures", "Cofre de Combat", "Frasc de fum ancestral"};

    private boolean usTresor = false;

    // Constructors
    public Tresor() {
        generarValorsTresor();
    }

    // Getters i Setters
    public void setNom(String nom) {
        this.nom = nom;
        usTresor = "Frasc de fum ancestral".equals(nom.trim()); 
    }

    public boolean isUsTresor() {
        return usTresor;
    }
    
    public int getValor() {
        return valor;
    }

    public boolean getUsTresor() { 
        return usTresor;
    }

    public String getNom() {
        return nom;
    }

    public double getPes() {
        return pes;
    }

    // Mètodes
    public void generarValorsTresor() {
        String[] array = this.nomsTresor;
        this.nom = array[generarValorAleatori(0, array.length - 1)];
        this.valor = generarValorAleatori(100, 3_000);
        this.pes = this.valor * 0.0075;

        setNom(this.nom);
    }
    
    // Función que nos dice si tiene uso o no
    private String mostrarMissatge() {
        if (usTresor) {
            return "Genera un núvol de fum ancestral que et porta a una altre punt a l'atzar (perd valor cada vegada que s'utilitza)";
        } else {
            return "Aquest tresor no té cap ús fora del seu valor";
        }
    }
    
    public void utilitzarFum (boolean uso, int valor) {
    	this.usTresor = uso;
    	this.valor = valor;
    		
    	// FUNCIÓN PARA USAR EL HUMO QUE NOS TELETRANSPORTA A UN LUIGAR ALEATORIO
    	if(usTresor) {
    		if(valor >= 10){
    			Personatge.move(generarValorAleatori(10, 10));
    			valor -= 10;
    		}else {
    			System.out.println("No hi ha fum suficient");
    		}
    	}else
    		System.out.println("Aquest tresor no té us");
    }

    @Override
    public String toString() {
        return "[nom=" + nom + ", valor=" + valor + ", pes=" + pes + ", " + mostrarMissatge() + "]";
    }
}


