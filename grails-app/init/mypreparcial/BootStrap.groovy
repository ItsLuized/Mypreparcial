package mypreparcial

import mypreparcial.*

class BootStrap {

    def init = { servletContext ->
        
        new Empleo(cargo:"Gerente Administrativo",requisitos:"Saber Ingles y Frances",
            salario:"1.000.000").save(failOnError:true);
        new Empleo(cargo:"Ingeniero de sistemas",requisitos:"JAVA, C++, Python",
            salario:"2.000.000").save(failOnError:true);
        new Empleo(cargo:"Profesor universitario",requisitos:"Experiencia de 3 años",
            salario:"3.500.000").save(failOnError:true);
        new Empleo(cargo:"Director de comunicaciones",requisitos:"Maestria",
            salario:"1.200.000").save(failOnError:true);
        
       // new Profesional(nombre:"Juan", apellido:"Obando",edad:"30", profesion:"Ingeniero Informático").save(failOnError:true); 
      //  new Profesional(nombre:"Luiz", apellido:"Martinez",edad:"30", profesion:"Ingeniero de Sistemas").save(failOnError:true); 
 
        def Profesional pf= new Profesional(nombre:"Juan", apellido:"Obando",edad:"30"
            , profesion:"Ingeniero Informático").save(failOnError:true);   
        pf.save(flush:true)
        
    }
    def destroy = {
    }
}
