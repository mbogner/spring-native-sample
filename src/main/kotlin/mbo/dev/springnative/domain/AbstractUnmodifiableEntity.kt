package mbo.dev.springnative.domain

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import org.jetbrains.annotations.NotNull
import java.time.Instant
import java.util.UUID

@MappedSuperclass
abstract class AbstractUnmodifiableEntity(
    id: UUID? = null,

    @NotNull
    @Column(
        name = "created_at",
        nullable = false,
        updatable = false
    )
    var createdAt: Instant? = null,

    ) : AbstractEntity(id = id) {


    @PrePersist
    open fun prePersist() {
        createdAt = Instant.now()
    }

}
