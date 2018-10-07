package mypreparcial

class Profesional {

    String nombre;
    String apellido;
    String edad;
    String profesion;
    static constraints = {
        nombre blank:false;
        apellido blank:false;
        edad blank:false;
        profesion blank:false;
    }
}
