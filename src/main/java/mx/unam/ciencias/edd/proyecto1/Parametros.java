package mx.unam.ciencias.edd.proyecto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import mx.unam.ciencias.edd.Lista;
public class Parametros {
    
    protected Parametros(){}

    protected int argumentosRecibidos(Lista <String> args){
        int flag1 = args.indiceDe("-r");
        int flag2 = args.indiceDe("-o");
        Lista <String> args1 = args;
        if(flag1 == flag2)
            if(args1.esVacia())
                return 0;
            else 
                return 1;
        else if(flag1 == -1 && flag2 != -1){
            args1.elimina("-o");
            args1.elimina(args1.get(flag2));
            if(args1.esVacia())
                return 0;
            else 
                return 1;
        
        } else if(flag1 != -1 && flag2 == -1){
            args1.elimina("-r");
            if(args1.esVacia())
                return 0;
            else 
                return 1;
        } else {
            args1.elimina("-o");
            args1.elimina(args1.get(flag2));
            args1.elimina("-r");
            if(args1.esVacia())
                return 0;
            else 
                return 1;
        }

    }

    protected void argumentos(Lista<String> args){
        //implementacion temporal
        
        Lista<String> temp = new Lista<>();
        
        for (String argumento : args) {
            temp.agregaFinal(argumento);
        }

        int indice = argumentosRecibidos(temp);
        
        if(indice == 1){
            flagsSinEntrada(args);
            
        } else 
            flagsConEntrada(args); 
        


    }

    private void flagsSinEntrada(Lista <String> args){
        Ordenador ordenador;
            System.out.println(args.toString());
            int flag1 = args.indiceDe("-r");
            int flag2 = args.indiceDe("-o");
            Lista<Linea> lista = new Lista<>();
            
            if(flag1 == flag2){
                lista = crearLista(args);
                ordenador = new Ordenador(lista);
                ordenador.listaOrdenada();
                ordenador.imprimirLista();

            } else if (flag1 != -1 && flag2 == -1){
                System.out.println("hola");
                args.elimina("-r");
                lista = crearLista(args);
                ordenador = new Ordenador(lista);
                ordenador.listaOrdenada();
                ordenador.girarLista();
                ordenador.imprimirLista();

            } else if (flag1 == -1 && flag2 != -1){
                args.elimina("-o");
                String temp = args.get(flag2);
                args.elimina(temp);
                lista = crearLista(args);
                ordenador = new Ordenador(lista);
                ordenador.listaOrdenada();
                ordenador.guardarLista(temp);
            } else if (flag1 != -1 && flag2 != -1){
                args.elimina("-o");
                String temp = args.get(flag2);
                args.elimina(temp);
                args.elimina("-r");
                System.out.println(args.toString());
                lista = crearLista(args);
                ordenador = new Ordenador(lista);
                ordenador.listaOrdenada();
                ordenador.girarLista();
                ordenador.guardarLista(temp);
            }
            
        

    }

    private void flagsConEntrada(Lista <String> args){
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Registrador leer = new Registrador();
        Ordenador ordenador;
        
        try {
            int flag1 = args.indiceDe("-r");
            int flag2 = args.indiceDe("-o");
            Lista<Linea> lista = new Lista<>();
            
            if(flag1 == flag2){
                lista = leer.lectorEntradaEstandar(buffer);
                ordenador = new Ordenador(lista);
                ordenador.listaOrdenada();
                ordenador.imprimirLista();

            } else if (flag1 != -1 && flag2 == -1){
                args.elimina("-r");
                lista = leer.lectorEntradaEstandar(buffer);
                ordenador = new Ordenador(lista);
                ordenador.listaOrdenada();
                ordenador.girarLista();
                ordenador.imprimirLista();

            } else if (flag1 == -1 && flag2 != -1){
                args.elimina("-o");
                String temp = args.get(flag2);
                args.elimina(temp);
                lista = leer.lectorEntradaEstandar(buffer);
                ordenador = new Ordenador(lista);
                ordenador.listaOrdenada();
                ordenador.guardarLista(temp);
            } else if (flag1 != -1 && flag2 != -1){
                args.elimina("-o");
                String temp = args.get(flag2);
                args.elimina(temp);
                args.elimina("-r");
                System.out.println(args.toString());
                lista = leer.lectorEntradaEstandar(buffer);
                ordenador = new Ordenador(lista);
                ordenador.listaOrdenada();
                ordenador.girarLista();
                ordenador.guardarLista(temp);
            }
        } catch (IOException e) {
            System.out.println("error en la accion");
        }
            
            
        

    }
    
    private Lista<Linea> crearLista(Lista<String> args){
        Lista<Linea> lista = new Lista<>();
        Lista<Linea> temp = new Lista<>();

        Registrador leer = new Registrador();
        while(!args.esVacia()){
            try {
                temp = leer.lector(args.getPrimero());
                args.eliminaPrimero();
                lista = pegarLista(lista, temp);    
               

            } catch (IOException e) {
                System.out.println("no existe algun archivo");
                break;
            }
        }
        
        return lista;
       
    }

    private Lista<Linea> pegarLista(Lista<Linea> actual, Lista<Linea> porPegar ){
        Lista<Linea> pegada = actual;
        for (Linea linea : porPegar) {
            pegada.agregaFinal(linea);
           }
        
           return pegada;
    }
    
}
