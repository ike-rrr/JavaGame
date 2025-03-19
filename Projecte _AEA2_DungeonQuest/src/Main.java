
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Tresor tresor = new Tresor();
		Personatge personatge = new Personatge("Hector");
		Sala sala = new Sala();
		Masmorra masmorra = new Masmorra();
		
		System.out.println(sala);
		System.out.println(tresor);
		System.out.println(personatge);
		masmorra.generarVista(masmorra);
		
	}

}
