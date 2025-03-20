
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
		Masmorra.generarVista(masmorra, personatge);

		Monstre monstre = new Monstre(2);
		
		System.out.println("sala: " + sala);
		System.out.println("tresor: " + tresor);
		System.out.println("personatge: " + personatge);
		System.out.println("monstre: " + monstre);
		
	}

}
