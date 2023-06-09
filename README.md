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
* Una vez compilado, lo ejecutamos con el siguiente comando:
```
$ java -jar target/proyecto.jar Archivo.txt
```
donde `Archivo.txt` puede ser un archivo de texto cualquiera y puede ser de cualquier ruta siempre y cuando esta sea correcta y puede ser mas de 1

* Tambien podemos ejecutarlo con la entrada estandar de la siguiente forma:
```
$ cat Archivo.txt | java -jar target/proyecto.jar
```
* podemos colocar las flags "-r" para que el resultado del ordenamiento este invertido o la flag "-o" seguida de una ruta de archivo para guradar el resultado, ambas pueden ser colocadas antes o despues de los archivos a ordenar de la siguiente forma:
```
$ java -jar target/proyecto.jar -r Archivo.txt
```
```
$ java -jar target/proyecto.jar Archivo.txt -r
```
```
$ java -jar target/proyecto.jar -o Destino.txt Archivo.txt
```
```
$ java -jar target/proyecto.jar Archivo.txt -o Destino.txt
```
```
cat Archivo.txt | java -jar target/proyecto.jar -r
```
```
cat Archivo.txt | java -jar target/proyecto.jar -o Destino.txt
```
o cualquier combinacion que se pueda hacer. siempre y cuando sea valida.

