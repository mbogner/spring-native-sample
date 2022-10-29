package mbo.dev.springnative

import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import mbo.dev.springnative.domain.AbstractEntity
import mbo.dev.springnative.domain.CrudService
import org.junit.jupiter.api.Test

abstract class AbstractCrudServiceTest<T : AbstractEntity> constructor(
    protected val crud: CrudService<T>,
    em: EntityManager,
) : AbstractCrdServiceTest<T>(crud, em) {

    @Test
    @Transactional(Transactional.TxType.REQUIRED)
    override fun crud() {
        val created = create()
        val read = read(created)
        val updated = update(read)
        delete(updated)
    }

    protected fun update(read: T): T {
        changeBeforeUpdate(read)
        val updated = crud.update(read)
        checkAfterUpdate(updated)
        return updated
    }

    /**
     * You can change fields in the entity before an update.
     */
    protected fun changeBeforeUpdate(entity: T) {}

    /**
     * You can also check your update after it was executed.
     */
    protected fun checkAfterUpdate(updated: T) {}

}
