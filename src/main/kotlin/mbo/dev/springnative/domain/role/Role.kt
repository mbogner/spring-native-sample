package mbo.dev.springnative.domain.role

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import mbo.dev.springnative.domain.AbstractModifiableEntity
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import org.jetbrains.annotations.NotNull
import java.time.Instant
import java.util.UUID

@Entity
@Table(
    name = "app_role", uniqueConstraints = [
        UniqueConstraint(name = "uc_app_role__name", columnNames = ["name"])
    ]
)
class Role(
    @NotNull
    @Column(nullable = false)
    var name: String,

    @Suppress("JpaAttributeTypeInspection")
    @NotNull
    @Column(nullable = false, columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    var grants: MutableMap<String, Boolean> = mutableMapOf(),

    id: UUID? = null,
    createdAt: Instant? = null,
    updatedAt: Instant? = null,
    lockVersion: Long? = null,
) : AbstractModifiableEntity(
    id = id,
    createdAt = createdAt,
    updatedAt = updatedAt,
    lockVersion = lockVersion,
) {
}
