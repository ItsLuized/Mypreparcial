package mypreparcial

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TrabajoServiceSpec extends Specification {

    TrabajoService trabajoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Trabajo(...).save(flush: true, failOnError: true)
        //new Trabajo(...).save(flush: true, failOnError: true)
        //Trabajo trabajo = new Trabajo(...).save(flush: true, failOnError: true)
        //new Trabajo(...).save(flush: true, failOnError: true)
        //new Trabajo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //trabajo.id
    }

    void "test get"() {
        setupData()

        expect:
        trabajoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Trabajo> trabajoList = trabajoService.list(max: 2, offset: 2)

        then:
        trabajoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        trabajoService.count() == 5
    }

    void "test delete"() {
        Long trabajoId = setupData()

        expect:
        trabajoService.count() == 5

        when:
        trabajoService.delete(trabajoId)
        sessionFactory.currentSession.flush()

        then:
        trabajoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Trabajo trabajo = new Trabajo()
        trabajoService.save(trabajo)

        then:
        trabajo.id != null
    }
}
