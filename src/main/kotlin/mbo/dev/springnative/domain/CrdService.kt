package mbo.dev.springnative.domain

import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import java.util.UUID

@Transactional(Transactional.TxType.MANDATORY)
abstract class CrdService<T : AbstractEntity>(
    private val repo: JpaRepositoryExt<T, UUID>
) {

    /**
     * Create a new entity. Automatically flushes and refreshes the object to reflect database triggers.
     */
    fun create(entity: T): T {
        if (null != entity.id) {
            throw IllegalStateException("entity with id can't be created. use update to update an existing entity!")
        }
        return saveRefresh(entity)
    }

    /**
     * Get an entity by id or null if not found.
     */
    fun read(id: UUID): T? {
        return try {
            repo.getReferenceById(id)
        } catch (exc: EntityNotFoundException) {
            null
        }
    }

    /**
     * Delete entity by id. If id isn't found the call is silently ignored.
     */
    fun deleteById(id: UUID) {
        repo.deleteById(id)
    }

    protected open fun saveRefresh(entity: T): T {
        val result = repo.saveAndFlush(entity)
        repo.refresh(result)
        return result
    }
}
