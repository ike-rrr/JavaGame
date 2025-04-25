
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Tresor tresor = new Tresor();
		Personatge personatge = new Personatge("Hector");
		Sala sala = new Sala();
		boolean haFinalitzat = false;
		
		Masmorra masmorra = new Masmorra(personatge);
		do {
			haFinalitzat = masmorra.mostrarMenu();
			
		} while (!haFinalitzat);
		
		
	}

}
