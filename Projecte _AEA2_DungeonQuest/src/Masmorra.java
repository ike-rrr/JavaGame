import java.util.Arrays;

public class Masmorra {
    private Monstre[] arrayMonstres;
    private Tresor[] arrayTresors;
    private Sala[][] matriuSales;
    private int nombreMonstres;
    private int nombreTresors;
    
    public Masmorra() {
        this.matriuSales = new Sala[10][10];
        crearSales();
        matriuSales[0][0].setPortaE(true); 
        tamanyArrays();
        omplirMasmorra();
    }

    public static Sala[][] getMatriuSales(Masmorra masmorra) {
        return masmorra.matriuSales;
    }

    private void tamanyArrays() {
        nombreMonstres = 0;
        nombreTresors = 0;
        
        for (Sala[] fila : matriuSales) {
            for (Sala sala : fila) {
                if (sala.isMonstre()) nombreMonstres++;
                if (sala.isTresor()) nombreTresors++;
            }
        }

        this.arrayMonstres = new Monstre[nombreMonstres];
        this.arrayTresors = new Tresor[nombreTresors];
    }

    private void crearSales() {
        for (int i = 0; i < matriuSales.length; i++) {
            for (int j = 0; j < matriuSales[i].length; j++) {
                matriuSales[i][j] = new Sala();
            }
        }
    }

    private void omplirMasmorra() {
        int contadorMonstre = 0;
        int contadorTresor = 0;
        
        for (Sala[] fila : matriuSales) {
            for (Sala sala : fila) {
                if (sala.isMonstre()) {
                    arrayMonstres[contadorMonstre++] = sala.getEnemic();
                }
                if (sala.isTresor()) {
                    arrayTresors[contadorTresor++] = sala.getRecompensa();
                }
            }
        }
    }

    public static void generarVista(Masmorra masmorra, Personatge personatge) {
        for (int i = 0; i < masmorra.matriuSales.length; i++) {
            for (int j = 0; j < masmorra.matriuSales[i].length; j++) {
                if (i == personatge.getPosicio(personatge).x && 
                    j == personatge.getPosicio(personatge).y) {
                    System.out.print("(&)");
                } else if (masmorra.matriuSales[i][j].getExplorada()) {
                    System.out.print("(*)");
                } else {
                    System.out.print("(-)");
                }
            }
            System.out.println();
        }
    }
}