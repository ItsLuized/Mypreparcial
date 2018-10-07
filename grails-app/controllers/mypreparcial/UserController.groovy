package mypreparcial

class UserController {

    def index() 
    { 
    }
    def login()
    {
        if(params.username=="admin" && params.password=="123")
        {
          redirect(controller: "Report_emp_pro", action: "report")
        }
        else
        {
          render "Wrong"
        }
    }
}
