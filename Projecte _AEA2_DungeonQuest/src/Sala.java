/*
 * 
 * PRIMERA VERSIÓN
import java.util.Random;

public class Sala extends Joc {
	// PROPIEDADES
	private String tipus;
	private boolean tresor;
	private boolean monstre;
	private boolean explorada;
	private int numPortes;
	private String[] portes = {"", "", "", ""}; // Norte, Sur, Este, Oeste  // REVISAR
	private Monstre monstreObj;
	private Tresor tresorObj;

	// Mapeo de direcciones  // NUEVO
	private static final String[] DIRECCIONS = {"N", "S", "E", "O"}; // REVISAR

	// CONSTRUCTOR
	public Sala(String portaEntrada) {  // REVISAR
		Random rand = new Random();

		// Determinar tipo de sala
		int tipo = tipoSala();
		if (tipo <= 70) {
			tipus = "Normal";
		} else if (tipo <= 85) {
			tipus = "Pont";
		} else {
			tipus = "Teranyna";
		}


		tresor = rand.nextBoolean();
		monstre = rand.nextBoolean();
		generarMonstre();
		explorada = false;
		numPortes = 1; // Mínimo una puerta (entrada) // REVISAR

		// Agregar la puerta de entrada en la posición correcta // REVISAR
		if (portaEntrada != null) { 
			afegirPorta(getPortaOposada(portaEntrada));
		}

		// Generar puertas aleatorias adicionales // NUEVO
		generarPortesAleatories();
	}

	/
	 // Funció que genera un Monstre si el boolean que ho representa és True

	private void generarMonstre() {
		if (this.monstre == true) {
			Monstre monstreObj = new Monstre(generarValorAleatori(5, 20));
		}

	}


	 // Funció que genera un Tresor si el boolean que ho representa és True

	private void generarTresor() {
		if (this.tresor == true) {
			Tresor tresorObj = new Tresor();
		}

	}

	// Método para agregar una puerta en la posición correcta // REVISAR
	private void afegirPorta(String porta) {
		int i = 0;
		while (i< DIRECCIONS.length) {
			if (DIRECCIONS[i].equals(porta) && portes[i].isEmpty()) {
				portes[i] = porta;
				numPortes++;
				i++;
			}
			i++;
		}
	}

	// Genera puertas adicionales aleatoriamente // REVISAR
	private void generarPortesAleatories() {
		Random rand = new Random();

		// Determinar número de puertas adicionales (máximo 3 más) // REVISAR
		int numPortesExtras = rand.nextInt(4 - numPortes);

		for (int i = 0; i < numPortesExtras; i++) {
			int index;
			do {
				index = rand.nextInt(4); // 0 = N, 1 = S, 2 = E, 3 = O
			} while (!portes[index].isEmpty()); // Evita duplicados // REVISAR

			portes[index] = DIRECCIONS[index];
			numPortes++;
		}
	}

	// Devolver la puerta opuesta 
	private String getPortaOposada(String porta) {
		switch (porta) {
		case "N": return "S";
		case "S": return "N";
		case "E": return "O";
		case "O": return "E";
		default: return null;
		}
	}

	// Genera un número aleatorio del 0 al 100 para determinar el tipo de sala
	private int tipoSala() {
		Random num = new Random();
		return num.nextInt(101);
	}

	@Override
	public String toString() {
		// Creamos el string para mostrar las direcciones de puerta
		String portesDisponibles = "";

		for (String porta : portes) {
			if (!porta.isEmpty()) {
				portesDisponibles += porta + " ";
			}
		}

		return "Sala [tipus= " + tipus + ", tresor= " + tresor + ", monstre= " + monstre +
				", numPortes= " + numPortes + ", explorada= " + explorada +
				(monstreObj != null ? ", Monstre= " + monstreObj.toString() : ", Sense Monstre") +
				", portes= " + portesDisponibles.trim() + "]";
	}

	// GETTERS i SETTERS

	public boolean getMonstres() {
		return this.monstre;
	}

	public Monstre getEnemic() {
		return this.monstreObj;
	}

	public boolean getTresors() {
		return this.tresor;
	}

	public Tresor getRecompensa() {
		return this.tresorObj;
	}

}
 */
/*
 * 
 * SEGUNDA VERSIÓN
import java.util.Random;

public class Sala extends Joc {
	// PROPIEDADES
	private String tipus;
	private boolean tresor;
	private boolean monstre;
	private boolean explorada;
	private int numPortes;
	private String[] portes = {"", "", "", ""}; // Norte, Sur, Este, Oeste  

	private Monstre monstreObj;
	private Tresor tresorObj;

	// Mapeo de direcciones  
	private static final String[] DIRECCIONS = {"N", "S", "E", "O"};  

	// CONSTRUCTOR sin parámetros para generar una puerta aleatoria
	public Sala() {  
		this(portaEntradaAleatoria()); 
	}

	// CONSTRUCTOR con parámetro opcional (MODIFICADO)
	public Sala(String portaEntrada) {  
		Random rand = new Random();

		// Determinar tipo de sala
		int tipo = tipoSala();
		if (tipo <= 70) {
			tipus = "Normal";
		} else if (tipo <= 85) {
			tipus = "Pont";
		} else {
			tipus = "Teranyna";
		}

		tresor = rand.nextBoolean();
		monstre = rand.nextBoolean();
		generarMonstre();
		explorada = false;
		numPortes = 1; // Mínimo una puerta (entrada)  

		// Agregar la puerta de entrada en la posición correcta
		if (portaEntrada != null) {  // (MODIFICADO: permite null sin errores)
			afegirPorta(getPortaOposada(portaEntrada));
		}

		// Generar puertas aleatorias adicionales
		generarPortesAleatories();
	}

	// Método para elegir una puerta de entrada aleatoria 
	private static String portaEntradaAleatoria() {
		Random rand = new Random();
		return DIRECCIONS[rand.nextInt(DIRECCIONS.length)];
	}

	// Genera un Monstre si el boolean lo indica
	private void generarMonstre() {
		if (this.monstre) {
			monstreObj = new Monstre(generarValorAleatori(5, 20));
		}
	}

	// Genera un Tresor si el boolean lo indica
	private void generarTresor() {
		if (this.tresor) {
			tresorObj = new Tresor();
		}
	}

	// Método para agregar una puerta en la posición correcta 
	private void afegirPorta(String porta) {
		for (int i = 0; i < DIRECCIONS.length; i++) {
			if (DIRECCIONS[i].equals(porta) && portes[i].isEmpty()) {
				portes[i] = porta;
				numPortes++;
				// TAL VEZ HAGA FALTA BUSCAR UNA MANERA DE CORTAR
			}
		}
	}

	// Genera puertas adicionales aleatoriamente 
	private void generarPortesAleatories() {
		Random rand = new Random();
		int numPortesExtras = rand.nextInt(4 - numPortes); // Máximo 3 puertas más

		for (int i = 0; i < numPortesExtras; i++) {
			int index;
			do {
				index = rand.nextInt(4);
			} while (!portes[index].isEmpty()); 

			portes[index] = DIRECCIONS[index];
			numPortes++;
		}
	}

	// Devuelve la puerta opuesta
	private String getPortaOposada(String porta) {
		switch (porta) {
		case "N": return "S";
		case "S": return "N";
		case "E": return "O";
		case "O": return "E";
		default: return null;
		}
	}

	// Genera un número aleatorio del 0 al 100 para determinar el tipo de sala
	private int tipoSala() {
		Random num = new Random();
		return num.nextInt(101);
	}

	@Override
	public String toString() {
		StringBuilder portesDisponibles = new StringBuilder(); // 
		for (String porta : portes) {
			if (!porta.isEmpty()) {
				portesDisponibles.append(porta).append(" ");
			}
		}

		return "Sala [tipus= " + tipus + ", tresor= " + tresor + ", monstre= " + monstre +
				", numPortes= " + numPortes + ", explorada= " + explorada +
				(monstreObj != null ? ", Monstre= " + monstreObj.toString() : ", Sense Monstre") +
				", portes= " + portesDisponibles.toString().trim() + "]";
	}

	// GETTERS y SETTERS
	public boolean getMonstres() {
		return this.monstre;
	}

	public Monstre getEnemic() {
		return this.monstreObj;
	}

	public boolean getTresors() {
		return this.tresor;
	}

	public Tresor getRecompensa() {
		return this.tresorObj;
	}
}
*/

import java.util.Random;

public class Sala extends Joc {
    // PROPIEDADES
    private String tipus;
    private boolean tresor;
    private boolean monstre;
    private boolean explorada;
    private int numPortes;
    private String[] portes = {"", "", "", ""}; // Norte, Sur, Este, Oeste  

    private Monstre monstreObj;
    private Tresor tresorObj;

    // Mapeo de direcciones  
    private static final String[] DIRECCIONS = {"N", "S", "E", "O"};  

    // CONSTRUCTOR para la primera sala (siempre tiene una puerta de entrada aleatoria) // MODIFICADO
    public Sala(boolean esPrimeraSala) {  
        this(esPrimeraSala ? portaEntradaAleatoria() : null); // MODIFICADO
    }

    // CONSTRUCTOR modificado // MODIFICADO
    public Sala(String portaEntrada) {  
        Random rand = new Random();

        // Determinar tipo de sala
        int tipo = tipoSala();
        if (tipo <= 70) {
            tipus = "Normal";
        } else if (tipo <= 85) {
            tipus = "Pont";
        } else {
            tipus = "Teranyna";
        }

        tresor = rand.nextBoolean();
        monstre = rand.nextBoolean();
        generarMonstre();
        explorada = false;
        numPortes = (portaEntrada != null) ? 1 : 0; // Solo si hay puerta de entrada // MODIFICADO

        // Agregar la puerta de entrada si existe // MODIFICADO
        if (portaEntrada != null) {
            afegirPorta(getPortaOposada(portaEntrada));
        }

        // Generar puertas adicionales // MODIFICADO
        generarPortesAleatories();
    }

    // Método para elegir una puerta de entrada aleatoria // MODIFICADO
    private static String portaEntradaAleatoria() {
        Random rand = new Random();
        return DIRECCIONS[rand.nextInt(DIRECCIONS.length)];
    }

    // Genera un Monstre si el boolean lo indica
    private void generarMonstre() {
        if (this.monstre) {
            monstreObj = new Monstre(generarValorAleatori(5, 20));
        }
    }

    // Genera un Tresor si el boolean lo indica
    private void generarTresor() {
        if (this.tresor) {
            tresorObj = new Tresor();
        }
    }

    // Método para agregar una puerta en la posición correcta 
    private void afegirPorta(String porta) {
        for (int i = 0; i < DIRECCIONS.length; i++) {
            if (DIRECCIONS[i].equals(porta) && portes[i].isEmpty()) {
                portes[i] = porta;
                numPortes++;
            }
        }
    }

    // Genera puertas adicionales aleatoriamente // MODIFICADO
    private void generarPortesAleatories() {
        Random rand = new Random();
        int numPortesExtras = rand.nextInt(4 - numPortes); // Máximo 3 puertas más // MODIFICADO

        for (int i = 0; i < numPortesExtras; i++) {
            int index;
            do {
                index = rand.nextInt(4);
            } while (!portes[index].isEmpty()); 

            portes[index] = DIRECCIONS[index];
            numPortes++;
        }
    }

    // Devuelve la puerta opuesta
    private String getPortaOposada(String porta) {
        switch (porta) {
            case "N": return "S";
            case "S": return "N";
            case "E": return "O";
            case "O": return "E";
            default: return null;
        }
    }

    // Genera un número aleatorio del 0 al 100 para determinar el tipo de sala
    private int tipoSala() {
        Random num = new Random();
        return num.nextInt(101);
    }

    @Override
    public String toString() {
        StringBuilder portesDisponibles = new StringBuilder(); 
        for (String porta : portes) {
            if (!porta.isEmpty()) {
                portesDisponibles.append(porta).append(" ");
            }
        }

        return "Sala [tipus= " + tipus + ", tresor= " + tresor + ", monstre= " + monstre +
                ", numPortes= " + numPortes + ", explorada= " + explorada +
                (monstreObj != null ? ", Monstre= " + monstreObj.toString() : ", Sense Monstre") +
                ", portes= " + portesDisponibles.toString().trim() + "]";
    }

    // GETTERS y SETTERS
    public boolean getMonstres() {
        return this.monstre;
    }

    public Monstre getEnemic() {
        return this.monstreObj;
    }

    public boolean getTresors() {
        return this.tresor;
    }

    public Tresor getRecompensa() {
        return this.tresorObj;
    }
}

