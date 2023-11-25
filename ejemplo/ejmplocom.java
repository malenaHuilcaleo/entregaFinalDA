public class ejmplocom {package ejemplos_InOut;
    //import java.io.*;
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.BufferedWriter;
    import java.io.FileNotFoundException;
    import java.io.FileWriter;
    import java.io.IOException;
    
    /**
     * Esta clase está hecha para dar un primer ejemplo rápido de cómo funcionan
     * algunas clases provistas por Java para el manejo de entrada/salida desde archivos
     * de texto.
     *
     * En otras clases del mismo paquete veremos cómo generar archivos con características
     * particulares, para generar conjuntos de valores aleatorios.
     */
    public class Ejemplo_1_InOut {
    
        public static void main(String[] args) {
            // Definimos los nombres de los archivos de entrada y salida.
            String nombreArchivoEntrada = "src/ejemplo_InOut/entrada.txt";
            String nombreArchivoSalida = "src/ejemplo_InOut/salida.txt";
    
            // ¿Qué pasa si tratamos de leer un archivo que no existe?
            // nombreArchivoEntrada = "noexiste.txt";
    
            // Mientras manipulamos archivos de texto, será común que operemos con
            // strings que representaran líneas de texto.
            String linea = null;
    
            try {
                // FileReader es una clase que nos permite leer texto desde un archivo.
                // https://docs.oracle.com/javase/7/docs/api/java/io/FileReader.html
                FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);
    
                // De la misma manera, nos interesa poder escribir en un archivo.
                // https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html
                FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);
    
                // Usamos buffer para la entrada/salida de un archivo de texto,
                // mejorando la performance de las operaciones de lectura y escritura.
                // https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html
                // https://docs.oracle.com/javase/7/docs/api/java/io/BufferedWriter.html
                BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
                BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
    
                // Mientras el buffer de lectura tenga algo por leer desde el archivo,
                // imprimimos cada línea por pantalla y la grabamos tal cual en el archivo.
                while ((linea = bufferLectura.readLine()) != null) {
                    System.out.println(linea);
                    bufferEscritura.write(linea + "\n");
                }
    
                // Cerramos los buffers para evitar riesgos de archivos corruptos.
                // Al cerrar el buffer, se cierra también su correspondiente archivo.
                bufferLectura.close();
                bufferEscritura.close();
            } catch (FileNotFoundException ex) {
                // Manejamos la excepción si el archivo de entrada no existe.
                System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                        + "que queríamos leer no existe.");
            } catch (IOException ex) {
                // Manejamos la excepción si hay un error leyendo o escribiendo en algún archivo.
                System.err.println("Error leyendo o escribiendo en algún archivo.");
            }
        }
    }
    
    
}
