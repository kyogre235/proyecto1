package mx.unam.ciencias.edd.proyecto1;

import java.io.IOException;
import mx.unam.ciencias.edd.Lista;

/**
 * Clase en la que se realizan las operaciones sobre de ordenamiento 
 * sobre una lista.
 */
public class Ordenador {
    /** la lista que se va a ordenar */
    Lista<Linea> lista;

    /*
     * constructor de Ordenador
     * @param lista una Lista<Linea> que se va a ordenar
     */
    protected Ordenador(Lista<Linea> lista) {
        this.lista = lista;
        
    }

    /**
     * metodo que ordena la lista con mergeSort();
     */
    protected void listaOrdenada(){
       lista = Lista.mergeSort(lista);
    }

    /**
     * se imprimen las Lineas de la lista
     */
    protected void imprimirLista(){
        String linea2;

        for (Linea linea : lista) {
            linea2 = linea.getLinea();
            System.out.println(linea2);
        }
    }

    /**
     * Guarda la lista en la ruta que se ingresa
     * @param ruta es la ruta del archivo donde se va a guardar
     */
    protected void guardarLista(String ruta){
        Registrador escritor = new Registrador();
        try {
            escritor.escritor(lista, ruta);  
        } catch (IOException e) {
            System.out.println("no se ha podido completar el guardado");
        }
        

    }

    /**
     * Regresa la reversa de la lista con el metodo .reversa();
     */
    protected void girarLista(){
        lista = lista.reversa();
    }
}
