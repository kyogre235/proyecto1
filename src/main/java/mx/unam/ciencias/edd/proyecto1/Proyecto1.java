package mx.unam.ciencias.edd.proyecto1;

import mx.unam.ciencias.edd.Lista;


public class Proyecto1{
    public static void main(String[] args) {
        
        Lista<String> args1 = new Lista<>(); 
        Parametros p = new Parametros();
        try {
            for (int i = 0; i < args.length ; i++)
                args1.agregaFinal(args[i]);
               
            p.argumentos(args1);
        } catch (ArrayIndexOutOfBoundsException e) {
            
            p.argumentos(args1);
        }

    }
}