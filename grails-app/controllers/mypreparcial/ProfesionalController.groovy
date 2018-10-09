package mypreparcial

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProfesionalController {

    ProfesionalService profesionalService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond profesionalService.list(params), model:[profesionalCount: profesionalService.count()]
    }

    def show(Long id) {
        respond profesionalService.get(id)
    }

    def create() {
        respond new Profesional(params)
    }

    def save(Profesional profesional) {
        if (profesional == null) {
            notFound()
            return
        }

        try {
            profesionalService.save(profesional)
        } catch (ValidationException e) {
            respond profesional.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'profesional.label', default: 'Profesional'), profesional.id])
                redirect profesional
            }
            '*' { respond profesional, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond profesionalService.get(id)
    }

    def update(Profesional profesional) {
        if (profesional == null) {
            notFound()
            return
        }

        try {
            profesionalService.save(profesional)
        } catch (ValidationException e) {
            respond profesional.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'profesional.label', default: 'Profesional'), profesional.id])
                redirect profesional
            }
            '*'{ respond profesional, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        profesionalService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'profesional.label', default: 'Profesional'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'profesional.label', default: 'Profesional'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
