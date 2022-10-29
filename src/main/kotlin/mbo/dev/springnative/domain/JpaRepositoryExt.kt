package mbo.dev.springnative.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

@NoRepositoryBean
interface JpaRepositoryExt<T : AbstractEntity, ID : Serializable> : JpaRepository<T, ID> {
    fun flushClear()
    fun refresh(entity: T)
}
