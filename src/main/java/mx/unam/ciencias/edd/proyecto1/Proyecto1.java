package mx.unam.ciencias.edd.proyecto1;

public class Proyecto1{
    public static void main(String[] args) {
      
        String prueba = "Hombres necios que acusáis";
        System.out.println(prueba+ "\n");

        Linea l = new Linea(prueba);
        System.out.println(l.toString());

    }
}