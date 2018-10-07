package mypreparcial

class Empleo {
    

    String cargo;
    String requisitos;
    String salario;
    static constraints = {
        cargo blank:false;
        requisitos blank:false;
        salario blank:false;
    }
}
