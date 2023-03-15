# Proyecto 1 : Estructuras de datos [EDD 23-2]
## Autor : Alejandro Jacome Delgado

### Notas :

* El proyecto toma los archivos de texto y los divide por lineas de texto (se denota una linea de texto como una cadena de caracteres que tiene al final "/n"), cada linea es guardada en un objeto de la clase Linea, en esta se genera una version normalizada de la linea de texto original, a la cual se le refiere como "Linea plana".
* La clase Linea implementa la interfaz Comparable, asi podemos guardar las instancias de la clase Linea en una Lista<Linea> para poder usar sus metodos de ordenamiento.
* El programa recibe las banderas "-r" y "-o" en cualquier orden, recordando que la bandera "-o" tomara el argumento inmediatamente susesor como el archivo en donde se va a guardar el resultado
  
### Uso
* Para compilar el proyecto utilizar el siguiente comando:
```
$ mvn install
```
  

