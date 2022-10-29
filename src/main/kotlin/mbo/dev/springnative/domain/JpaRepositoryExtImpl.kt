package mbo.dev.springnative.domain

import jakarta.persistence.EntityManager
import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation
import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import java.io.Serializable

class JpaRepositoryExtImpl<T : AbstractEntity, ID : Serializable>(
    domainClass: JpaMetamodelEntityInformation<T, ID>,
    protected val em: EntityManager,
) : SimpleJpaRepository<T, ID>(domainClass, em), JpaRepositoryExt<T, ID> {

    override fun flushClear() {
        em.flush()
        em.clear()
    }

    override fun refresh(entity: T) {
        em.refresh(entity)
    }

}
