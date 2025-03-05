
import java.util.Random;

public class Sala extends Joc {
    // PROPIEDADES

    private char tipus;

    private boolean tresor ;

    private boolean monstre;

    private int numPortes;

    private boolean explorada;


    // CONSTRUCTORES

    Sala(){

        if(tipoSala() <= 70) {
            tipus = 'N';
        }else if (tipoSala() <= 85) {
            tipus = 'P';
            
        }else {
            tipus = 'T';
            
        }

        tresor = apareixer();

        monstre = apareixer();

        explorada = false;
    }
    
    // Getters i Setters
	public void setExplorada(boolean explorada) {
		this.explorada = explorada;
	}
	
	public boolean getExplorada() {
		return this.explorada;
	}
	

    // MÉTODOS
	
	public static boolean isExplorada() {
		
	}

    // Booleano que hace si o no aleatorio
    private boolean apareixer() {
        Random rand = new Random ();
        boolean randomBoolean = rand.nextBoolean();
        return randomBoolean;
        
    }



	// Crea un número del 0 al 100 que determinará que tipo de sala es
    private int tipoSala() {
        Random num = new Random ();
        int randomInt= num.nextInt(101);
        return randomInt;
        
    }

	@Override
	public String toString() {
		return "Sala [tipus=" + tipus + ", tresor=" + tresor + ", monstre=" + monstre + ", numPortes=" + numPortes
				+ ", explorada=" + explorada + "]";
	}

}