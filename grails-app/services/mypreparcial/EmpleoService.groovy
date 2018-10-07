package mypreparcial

import grails.gorm.services.Service

@Service(Empleo)
interface EmpleoService {

    Empleo get(Serializable id)

    List<Empleo> list(Map args)

    Long count()

    void delete(Serializable id)

    Empleo save(Empleo empleo)

}