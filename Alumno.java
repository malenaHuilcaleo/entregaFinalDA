public class Alumno {

    private String apellido;
    private String nombre;
    private int legajo;
    private int grado;
    private double promedio;

    //constructor

    public Alumno(String apellido, String nom,int legajo, int gr, double prom){

        this.apellido=apellido;
        this.nombre=nom;
        this.legajo=legajo;
        this.grado=gr;
        this.promedio=prom;

    }
    public Alumno(String apellido, String nom,int legajo, int gr){

        this.apellido=apellido;
        this.nombre=nom;
        this.legajo=legajo;
        this.grado=gr;
    }

    //Métodos - Comportamiento 

    /****************************
             OBSERVADORES
    ****************************/

    public String getApellido(){
        return apellido;
    }
    public String getNombre(){
        return nombre;
    }
    public int getLegajo(){
        return legajo;
    }
     public int getGrado(){
        return grado;
    }
     public double getPromedio(){
        return promedio;
    }

     /****************************
             MODIFICADORES
    ****************************/
    public void setNombre(String nombre){

        this.nombre=nombre;
    }
     public void setApellido(String apellido){

        this.apellido=apellido;
    }
    public void setGrado(int grado){
        this.grado=grado;
    }

    public void setPromedio(double promedio){
        this.promedio=promedio;
    }


//


     /****************************
        PROPIOS DEL TIPO
    ****************************/




    
}
