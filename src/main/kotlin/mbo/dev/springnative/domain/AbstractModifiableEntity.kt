package mbo.dev.springnative.domain

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PreUpdate
import jakarta.persistence.Version
import java.time.Instant
import java.util.UUID

@MappedSuperclass
abstract class AbstractModifiableEntity(
    id: UUID? = null,
    createdAt: Instant? = null,

    @Column(nullable = false)
    var updatedAt: Instant? = null,

    @Version
    var lockVersion: Long? = null,

    ) : AbstractUnmodifiableEntity(
    id = id,
    createdAt = createdAt
) {

    override fun prePersist() {
        super.prePersist()
        lockVersion = 0
    }

    @PreUpdate
    open fun preUpdate() {
        updatedAt = Instant.now()
    }

}
