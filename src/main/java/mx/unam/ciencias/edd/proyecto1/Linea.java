package mx.unam.ciencias.edd.proyecto1;

import java.text.Normalizer;

/**
 * Clase que guarda en un objeto una linea de texto,
 * en forma de String, ademas crea una version de la
 * cadena sin espacios, sin mayusculas, sin acentos
 * y sin la ñ, que facilitara la comparacion entre 
 * lineas, a la cual llamaremos linea "plana".
 */
public class Linea implements Comparable<Linea> {
    /** String que guarda la linea deseada */    
    private String linea;
    /** version de la linea guardada en formato plano */
    private String lineaPlana;
    
    /**
     * metodo constructor de la clase Linea,
     * tambien genera la linea plana
     * @param linea es el String que recibe
     */
    protected Linea(String linea){
        this.linea = linea;
        lineaPlana = Normalizer.normalize(linea,Normalizer.Form.NFD);
        lineaPlana = lineaPlana.toLowerCase().replaceAll("[^a-z]", "");

    }
    /**
     * metodo que regresa la cadena dentro de Linea
     * @return la cadena dentro de Linea
     */
    public String getLineaPlana(){
        return lineaPlana;
    }

    public String getLinea(){
        return linea;
    }
    public String toString(){
        return linea;
    }
    /**
     * Compara la Linea que invoca el metodo con otra Linea
     * 
     * @return un n > 0 si la linea que llamo el metodo es mayor,
     * regresa un n < 0 si es menor y regresa n = 0 si es igual. 
     */
    @Override public int compareTo(Linea linea){
        //metodo por implementar
        //return temporal
        return this.lineaPlana.compareTo(linea.getLineaPlana());
        
    }
}
