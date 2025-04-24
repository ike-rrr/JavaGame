import java.util.Arrays;

public class Personatge extends Joc {
    private String nom;
    private int vida;
    private int atac;
    private int experiencia;
    private int agilitat;
    private int forsa;
    private int posicioX; // Coordenada X
    private int posicioY; // Coordenada Y
    private Tresor[] equipament;
    private static final int MAZMORRA_SIZE = 10; // Tamaño de la mazmorra (10x10)

    public Personatge(String nom) {
        this.nom = nom;
        generarValorsPersonatge();
    }

    public int getPosicioX() {
        return posicioX;
    }

    public int getPosicioY() {
        return posicioY;
    }

    private void setPosicio(int x, int y) {
        // Asegurar que las coordenadas estén dentro de los límites de la mazmorra
        if (x >= 0 && x < MAZMORRA_SIZE && y >= 0 && y < MAZMORRA_SIZE) {
            this.posicioX = x;
            this.posicioY = y;
        }
    }

    public void utilitzarTresor(int i) {
        if (i < 0 || i >= equipament.length || equipament[i] == null) return;

        Tresor objTresor = this.equipament[i];
        int valor = objTresor.getValor();
        boolean usTresor = objTresor.getUsTresor();

        if (usTresor) {
            if (valor >= 100) {
                this.setPosicio(generarValorAleatori(0, MAZMORRA_SIZE - 1), generarValorAleatori(0, MAZMORRA_SIZE - 1));
                objTresor.setValor(valor - 100);
            } else {
                System.out.println("No hi ha fum suficient");
            }
        } else {
            System.out.println("Aquest tresor no té us");
        }
    }

    public void explorarSala() {
        System.out.println("Explorant la sala actual...");
    }

    public void generarValorsPersonatge() {
        this.vida = generarValorAleatori(5, 20);
        this.atac = generarValorAleatori(1, 4);
        this.posicioX = 0; // Empieza en (0, 0)
        this.posicioY = 0;
        this.experiencia = 0;
        this.agilitat = generarValorAleatori(4, 11);
        this.forsa = generarValorAleatori(4, 11);
        this.equipament = new Tresor[forsa];
    }

    public void mourePersonatge(char direccio) {
        int newX = posicioX;
        int newY = posicioY;

        switch (direccio) {
            case 'N':
                newX--;
                break;
            case 'S':
                newX++;
                break;
            case 'E':
                newY++;
                break;
            case 'O':
                newY--;
                break;
            default:
                throw new IllegalArgumentException("Direcció no vàlida: " + direccio);
        }

        // Verificar límites antes de actualizar la posición
        if (newX >= 0 && newX < MAZMORRA_SIZE && newY >= 0 && newY < MAZMORRA_SIZE) {
            posicioX = newX;
            posicioY = newY;
        } else {
            System.out.println("No es pot sortir de la mazmorra!");
        }
    }

    @Override
    public String toString() {
        return "[nom=" + nom + ", vida=" + vida + ", atac=" + atac + ", experiencia=" + experiencia +
                ", agilitat=" + agilitat + ", forsa=" + forsa + ", posició=(" + posicioX + ", " + posicioY + ")" +
                ", equipament=" + Arrays.toString(equipament) + "]";
    }
}