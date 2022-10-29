package mbo.dev.springnative.domain

import java.util.UUID

abstract class CrudService<T : AbstractEntity>(
    repo: JpaRepositoryExt<T, UUID>
) : CrdService<T>(repo) {

    /**
     * Update an existing entity. Automatically flushes and refreshes the object to reflect database triggers.
     */
    fun update(entity: T): T {
        if (null == entity.id) {
            throw IllegalStateException("entity without id can't be updated. use create to create a new entity!")
        }
        return saveRefresh(entity)
    }

}
