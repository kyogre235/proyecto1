package mx.unam.ciencias.edd.proyecto1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import mx.unam.ciencias.edd.Lista;
/**
 * clase que hace la funcion de leer archivos o guardar en archivos.
 * 
 * Cuando se lee un archivo, separa cada linea de texto y las guarda en una Lista<Lineas>.
 * Cuando se guarda un archivo, toma cada linea de una Lista<Lineas> y las coloca adentro de 
 * un archivo. la clase no posee atributos, pues solo hace las operaciones de leer y guardar
 */
public class Registrador {
    /** Constructor del Regitrador, neseario para invocar los metodos*/
    protected Registrador(){}
   
    /**
     * Recibe la ruta de un archivo .txt y  separa cada linea de texto para
     * formar una Lista<Linea> 
     * @param archivo es la ruta del archivo a leer
     * @return una Lista<Linea> con las lineas del archivo de la ruta
     * @throws IOException si la ruta dada no existe 
     */
    protected Lista<Linea> lector(String archivo)throws IOException{
        Lista<Linea> listaLeidos = new Lista<>();
        Linea linea = new Linea("");

        try (BufferedReader lectorplano = new BufferedReader(new FileReader(archivo))) {   
            String lineaActual;  

            while ((lineaActual = lectorplano.readLine()) != null){
                linea = new Linea(lineaActual);
                listaLeidos.agrega(linea); 
            } 
            lectorplano.close(); 
            return listaLeidos;
        } catch (IOException e) {  
            throw new IOException("este archivo no existe");
        }
        
   }

   protected Lista<Linea> lectorEntradaEstandar(BufferedReader reader) throws IOException{
        Lista<Linea> listaLeidos = new Lista<>();
        Linea linea = new Linea("");

        try {
            String lineaActual;  

            while ((lineaActual = reader.readLine()) != null){
                linea = new Linea(lineaActual);
                listaLeidos.agrega(linea);   
            }
            reader.close();
            return listaLeidos;
        } catch (IOException e) {
            throw new IOException("este archivo no existe");
        }  
   }
   /**
    * metodo que guarda en un archivo .txt las lineas ordenadas del texto
    * @param lista es la lista<Linea> que va a guardar
    * @param ruta es la ruta donde del archivo donde se va a guardar, si el archivo no existe, lo crea.
    * @throws IOException si no puede guardar correctamente
    */
    protected void escritor(Lista<Linea> lista, String ruta) throws IOException {
        try {
        File archivo = new File(ruta);

        if(!archivo.exists())
            archivo.createNewFile();
        FileWriter escritorArchivo = new FileWriter(archivo);
        BufferedWriter buffer = new BufferedWriter(escritorArchivo);
            
        while(!lista.esVacia()){
            buffer.write(lista.getPrimero().getLinea()+"\n");
            lista.eliminaPrimero();
        }
        buffer.close();
        } catch (IOException e) {
            throw new IOException("accion no valida");
        }
    }
}
