package mypreparcial

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmpleoServiceSpec extends Specification {

    EmpleoService empleoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Empleo(...).save(flush: true, failOnError: true)
        //new Empleo(...).save(flush: true, failOnError: true)
        //Empleo empleo = new Empleo(...).save(flush: true, failOnError: true)
        //new Empleo(...).save(flush: true, failOnError: true)
        //new Empleo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //empleo.id
    }

    void "test get"() {
        setupData()

        expect:
        empleoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Empleo> empleoList = empleoService.list(max: 2, offset: 2)

        then:
        empleoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        empleoService.count() == 5
    }

    void "test delete"() {
        Long empleoId = setupData()

        expect:
        empleoService.count() == 5

        when:
        empleoService.delete(empleoId)
        sessionFactory.currentSession.flush()

        then:
        empleoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Empleo empleo = new Empleo()
        empleoService.save(empleo)

        then:
        empleo.id != null
    }
}
