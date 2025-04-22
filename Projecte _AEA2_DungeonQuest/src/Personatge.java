import java.awt.Point;
import java.util.Arrays;

public class Personatge extends Joc {
    private String nom;
    private int vida;
    private int atac;
    private int experiencia;
    private int agilitat;
    private int forsa;
    private Point posicio = new Point();
    private Tresor[] equipament;

    public Personatge(String nom) {
        this.nom = nom;
        generarValorsPersonatge();
    }

    public static Point getPosicio(Personatge personatge) {
        return personatge.posicio;
    }
    
    private void setPosicio(int x, int y) {
        this.posicio.x = x;
        this.posicio.y = y;
    }

    public void utilitzarTresor(int i) {
        if (i < 0 || i >= equipament.length || equipament[i] == null) return;
        
        Tresor objTresor = this.equipament[i];
        int valor = objTresor.getValor();
        boolean usTresor = objTresor.getUsTresor();
        
        if(usTresor) {
            if(valor >= 100){
                this.setPosicio(generarValorAleatori(0, 10), generarValorAleatori(0, 10));
                objTresor.setValor(valor - 100);
            } else {
                System.out.println("No hi ha fum suficient");
            }
        } else {
            System.out.println("Aquest tresor no té us");
        }
    }
    
    public void explorarSala() {
        // Implementación básica - debería interactuar con la sala actual
        System.out.println("Explorant la sala actual...");
    }

    public void generarValorsPersonatge() {
        this.vida = generarValorAleatori(5, 20);
        this.atac = generarValorAleatori(1, 4);
        this.posicio.setLocation(0, 0); // Empieza en (0,0)
        this.experiencia = 0;
        this.agilitat = generarValorAleatori(4, 11);
        this.forsa = generarValorAleatori(4, 11);
        this.equipament = new Tresor[forsa];
    }

    public void mourePersonatge(char direccio) {
        switch (direccio) {
            case 'N':
                if (posicio.x > 0) posicio.x--;
                break;
            case 'S':
                posicio.x++;
                break;
            case 'E':
                posicio.y++;
                break;
            case 'O':
                if (posicio.y > 0) posicio.y--;
                break;
            default:
                throw new IllegalArgumentException("Direcció no vàlida: " + direccio);
        }
    }

    @Override
    public String toString() {
        return "[nom=" + nom + ", vida=" + vida + ", atac=" + atac + ", experiencia=" + experiencia +
                ", agilitat=" + agilitat + ", forsa=" + forsa + ", posició=" + posicio + 
                ", equipament=" + Arrays.toString(equipament) + "]";
    }
}