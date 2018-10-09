package mypreparcial

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmpleoController {

    EmpleoService empleoService 
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond empleoService.list(params), model:[empleoCount: empleoService.count()]
    }

    def show(Long id) {
        respond empleoService.get(id)
    }

    def create() {
        respond new Empleo(params)
    }

    def save(Empleo empleo) {
        if (empleo == null) {
            notFound()
            return
        }

        try {
            empleoService.save(empleo)
        } catch (ValidationException e) {
            respond empleo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'empleo.label', default: 'Empleo'), empleo.id])
                redirect empleo
            }
            '*' { respond empleo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond empleoService.get(id)
    }

    def update(Empleo empleo) {
        if (empleo == null) {
            notFound()
            return
        }

        try {
            empleoService.save(empleo)
        } catch (ValidationException e) {
            respond empleo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'empleo.label', default: 'Empleo'), empleo.id])
                redirect empleo
            }
            '*'{ respond empleo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        empleoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'empleo.label', default: 'Empleo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'empleo.label', default: 'Empleo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
