public class TresorSenseUs extends Tresor {
    @Override
    public boolean getUsTresor() {
        return false;
    }

    @Override
    public String mostrarMissatge() {
        return "Aquest tresor no té cap ús especial";
    }
    
    @Override
    public String toString() {
        return "[nom=" + getNom() + ", valor=" + getValor() + "]";
    }
}