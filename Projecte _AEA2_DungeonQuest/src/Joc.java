import java.util.Random;

public class Joc {

	// Mètodes del Joc 
	/**
	 * 	Funció que comprova que no es surti del límit de la matriu
	 * @param posicio
	 * @param longitudArray
	 * @return
	 */
	public boolean estaFora(int posicio, int longitudArray) {
		return (posicio - 1 < 0 || posicio + 1 > longitudArray);
		
	}
	
	
	/**
	 * Funció que genera un valor aleatori en un rang establert amb mínim i màxim i retorna el valor
	 * @param min
	 * @param max
	 * @return
	 */
	public static int generarValorAleatori(int min, int max) {
		Random random = new Random();
		return (random.nextInt(max - min + 1) + min);
		
	}
}
