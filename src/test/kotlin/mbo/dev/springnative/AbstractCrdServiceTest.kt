package mbo.dev.springnative

import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import mbo.dev.springnative.domain.AbstractEntity
import mbo.dev.springnative.domain.CrdService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

abstract class AbstractCrdServiceTest<T : AbstractEntity> constructor(
    protected val service: CrdService<T>,
    protected val em: EntityManager,
) : AbstractSpringBootTest() {

    abstract fun validInstance(): T

    @Test
    @Transactional(Transactional.TxType.REQUIRED)
    fun crud() {
        val created = create()
        val read = read(created)
        delete(read)
    }

    protected fun create(): T {
        val created = service.create(validInstance())
        assertThat(created.id).isNotNull
        return created
    }

    protected fun read(created: T): T {
        return service.read(created.id!!)!!
    }

    protected fun delete(read: T) {
        service.deleteById(read.id!!)
    }

}
