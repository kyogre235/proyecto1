package mx.unam.ciencias.edd.proyecto1;

import java.io.IOException;
import mx.unam.ciencias.edd.Lista;

public class Ordenador {
    
    Lista<Linea> lista;

    protected Ordenador(Lista<Linea> lista) {
        this.lista = lista;
        
    }

    protected void listaOrdenada(){
       lista = Lista.mergeSort(lista);
    }

    protected void imprimirLista(){
        String linea2;

        for (Linea linea : lista) {
            linea2 = linea.getLinea();
            System.out.println(linea2);
        }
    }

    protected void guardarLista(String ruta){
        Registrador escritor = new Registrador();
        try {
            escritor.escritor(lista, ruta);  
        } catch (IOException e) {
            System.out.println("no se ha podido completar el guardado");
        }
        

    }
    protected void girarLista(){
        lista = lista.reversa();
    }
}
