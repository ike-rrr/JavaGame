public class Main {
    public static void main(String[] args) {
        TresorAmbUs tresorAmbUs = new TresorAmbUs();
        TresorSenseUs tresorSenseUs = new TresorSenseUs();
        Personatge personatge = new Personatge("Hector");
        Sala sala = new Sala();
        Masmorra masmorra = new Masmorra();

        System.out.println(sala);
        System.out.println(tresorAmbUs);
        System.out.println(tresorSenseUs);
        System.out.println(personatge);
        
        Masmorra.generarVista(masmorra, personatge);
        System.out.println();
        
        personatge.mourePersonatge('E');
        Masmorra.generarVista(masmorra, personatge);
    }
}