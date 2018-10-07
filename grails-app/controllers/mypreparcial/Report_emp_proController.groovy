package mypreparcial

class Report_emp_proController {

    static defaultAction= "report"
    def index() 
    { 
        
    }
    def report()
    {
        def Empleos = Empleo.list()
        def Profesionales = Profesional.list()
        render(view: "report_emp_pro", model: [empleos : Empleos, profesionales : Profesionales])
    }
}
