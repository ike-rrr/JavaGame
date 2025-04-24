import java.util.Random;
import java.util.Scanner;

public abstract class Joc {

	// Mètodes del Joc 
	/**
	 * 	Funció que comprova que no es surti del límit de la matriu
	 * @param posicio
	 * @param longitudArray
	 * @return
	 */
	public boolean estaFora(int posicio, int longitudArray) {
		return (posicio < 0 || posicio > longitudArray);
		
	}
	
	
	/**
	 * Funció que genera un valor aleatori en un rang establert amb mínim i màxim i retorna el valor
	 * @param min
	 * @param max
	 * @return
	 */
	public int generarValorAleatori(int min, int max) {
		Random random = new Random();
		return (random.nextInt(max - min + 1) + min);
		
	}
	
	/**
	 * Funció que demana una resposta a l'usuari de valor numèric.
	 */
	public int demanarResposta(int longitud) {
		Scanner teclado = new Scanner(System.in);
		Integer resposta;
		// Demanara una resposta fins que aquesta no surti dels marges determinats.
		do {
			System.out.println("Ingresa un número del llistat");
			 resposta = teclado.nextInt();
		} while ((resposta < 1 || resposta > longitud));
		return resposta;
	}
}
