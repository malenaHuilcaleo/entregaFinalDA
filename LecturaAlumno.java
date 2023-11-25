import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class LecturaAlumno {
    public static void main(String[] args) {


        
        //String listaDesaprobados= "ListaDesaprobados.txt";
        
//7 grados con un maximo de 30 alumnos por grado
            Alumno[][] matAlumnos= new Alumno [7][30];
            
           // mostrarMatriz(matAlumnos);
            //System.out.println("*******************************************************************");
           // procesarLista(listaIngresantes, matAlumnos);
            // mostrarMatriz(matAlumnos);

            Scanner sc=new Scanner(System.in);
            int opcion;

            do{
                mostrarMenu();
                System.out.print("Ingrese la opcion deseada: ");
                opcion=sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("seleccionaste la opcion 1");
                        System.out.println("Ingrese el nombre del archivo que desea procesar  0 para salir");
                        String nombreArchivo=sc.next();
                        if("0".equals(nombreArchivo)) opcion=0;
                        else{
                            procesarLista(nombreArchivo, matAlumnos);
                            mostrarMatriz(matAlumnos);

                            opcion=-1;
                        } break;
                    case 2:
                    System.out.println("Seleccionaste la opcion 2");
                    System.out.println("ingrese el nombre del archivo con la lista de repitentes");
                
                    default:
                    System.out.println("Opción invalida. Intentalo nuevamente");
                        break;
                
                }
            }while(opcion!=0);
    }

    public static void mostrarMenu(){
        System.out.println("---Menú----");
        System.out.println("0. Salir");
        System.out.println("1. Cargar archivos");
        System.out.println("2. Pasar alumnos de grado");
    }
        

    //modulo para procesar los archivos de lista alumnos y lista ingresantes(ya que tienen la misma estructura)
    public static void procesarLista(String nomArchivo, Alumno[][] matAlum){
         
        try {
            FileReader leeArch= new FileReader(nomArchivo);
            BufferedReader bufferLectura = new BufferedReader(leeArch);

            String linea=null;
            

            while((linea=bufferLectura.readLine()) !=null){
                Scanner sc= new Scanner(linea);
                sc.useDelimiter(";");

                //obtengo la informacion de cada col 
                //-apellido, nombbre, legajo, grado, prom-

                String apellido= sc.next();
                String nombre= sc.next();
                String legajoStr = sc.next();
                int legajo = Integer.parseInt(legajoStr);
                String graStr= sc.next();
                int grado= Integer.parseInt(graStr);
                String promStr= sc.next();
                double promedio=Double.parseDouble(promStr);
                Alumno alum= new Alumno(apellido, nombre, legajo, grado, promedio);
                cargarMatriz(matAlum, alum);
                 sc.close(); 
            }

            bufferLectura.close();

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "       + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo algun archivo.");
        }
    }
      

   

    public static void cargarMatriz(Alumno [][]mat, Alumno unAlumno){
        int grTem= unAlumno.getGrado()-1;
        int col=encontrarCol(mat, grTem);
        //si se encontro un lugar en el grado (que esta limitado a 30 alumnos)
        if(col !=-1){
             mat[grTem][col]=unAlumno; 
        }else{}

    }
    

//modulo para encontrar el primer lugar disponible dentro de la matriz
private static int encontrarCol(Alumno [][]mat, int grado){
    int i=0;
    int alumnosxGrado= mat[0].length-1;//cantidad de lugares por grado 
    int numcol=-1;//posicion disponible 
    

    //no recorre toda la matriz sino solo donde requiero cargar a un alumno
   
    while(mat[grado][i]!=null && i< alumnosxGrado){
        i++;
    }
    if (i!=alumnosxGrado)   numcol=i;
 
    return numcol;
}



public static void mostrarMatriz(Alumno[][] mat) {
    System.out.println("Matriz de Alumnos:");

    for (int i = 0; i < mat.length; i++) {
        System.out.print("Grado " + (i + 1) + ": ");

        for (int j = 0; j < mat[0].length; j++) {
            if (mat[i][j] != null) {
                // col  no vacia
                System.out.print("(" + mat[i][j].getApellido()  +")");
            } else {
                // col vacía
                System.out.print("null ");
            }
            
        }

        System.out.println(); 
        System.out.println(); // Nueva línea para separar los grados
    }
}

 }




