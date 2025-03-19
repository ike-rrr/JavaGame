
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Tresor tresor = new Tresor();
		Personatge personatge = new Personatge("Hector");
		Sala sala = new Sala();
		Monstre monstre = new Monstre(2);
		
		System.out.println("sala: " + sala);
		System.out.println("tresor: " + tresor);
		System.out.println("personatge: " + personatge);
		System.out.println("monstre: " + monstre);
		
	}

}
