import java.util.Random;

public class Sala extends Joc {
	private String tipus;
	private boolean tresor;
	private boolean monstre;
	private boolean explorada;
	private Monstre monstreObj;
	private Tresor tresorObj;
	private boolean portaN;
	private boolean portaS;
	private boolean portaE;
	private boolean portaO;

	public Sala(){
		int tipusSala = tipoSala();
		if(tipusSala <= 70) {
			tipus = "Normal";
		} else if (tipusSala <= 85) {
			tipus = "Pont";
		} else {
			tipus = "Teranyina";
		}

		tresor = apareixer();
		monstre = apareixer();
		generarTresor();
		generarMonstre();

		portaN = apareixer();
		portaS = apareixer();
		setPortaE(apareixer());
		portaO = apareixer();

		if(!portaN && !portaS && !isPortaE() && !portaO) {
			setPortaE(true);
		}

		explorada = false;
	}

	public void setExplorada(boolean explorada) {
		this.explorada = explorada;
	}

	public boolean getExplorada() {
		return this.explorada;
	}

	public boolean hasPortaN() { return portaN; }
	public boolean hasPortaS() { return portaS; }
	public boolean hasPortaE() { return isPortaE(); }
	public boolean hasPortaO() { return portaO; }

	private boolean apareixer() {
		Random rand = new Random();
		return rand.nextBoolean();
	}

	public boolean isTresor() {
		return tresor;
	}

	public Tresor getRecompensa() {
		return this.tresorObj;
	}

	public boolean isMonstre() {
		return monstre;
	}

	public Monstre getEnemic() {
		return this.monstreObj;
	}

	private void generarMonstre() {
		if (this.monstre) {
			monstreObj = new Monstre(generarValorAleatori(5, 20));
		}
	}

	private void generarTresor() {
		boolean tresorUs = apareixer();
		if (this.tresor && tresorUs) {
			tresorObj = new TresorAmbUs();
		} else if (this.tresor) {
			tresorObj = new TresorSenseUs();
		}
	}

	private int tipoSala() {
		Random num = new Random();
		return num.nextInt(101);
	}

	@Override
	public String toString() {
		String sortides = "Sortides: ";
		sortides += (portaN ? "N" : "");
		sortides += (portaS ? "S" : "");
		sortides += (isPortaE() ? "E" : "");
		sortides += (portaO ? "O" : "");

		return "Sala [tipus=" + tipus + 
				(monstreObj != null ? ", Monstre=" + monstreObj.toString() : "") + 
				(tresorObj != null ? ", Tresor=" + tresorObj.toString() : "") +
				", " + sortides + "]";
	}

	public boolean isPortaE() {
		return portaE;
	}

	public void setPortaE(boolean portaE) {
		this.portaE = portaE;
	}
}
