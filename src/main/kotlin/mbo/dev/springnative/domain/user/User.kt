package mbo.dev.springnative.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import mbo.dev.springnative.domain.AbstractModifiableEntity
import mbo.dev.springnative.domain.userrolemapping.UserRoleMapping
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import org.jetbrains.annotations.NotNull
import java.time.Instant
import java.util.UUID

@Entity
@Table(
    name = "app_user", uniqueConstraints = [
        UniqueConstraint(name = "uc_app_user__email", columnNames = ["email"])
    ]
)
class User(
    @NotNull
    @Column(nullable = false)
    var email: String,

    @NotNull
    @Column(nullable = false)
    var active: Boolean = true,

    @Suppress("JpaAttributeTypeInspection")
    @NotNull
    @Column(nullable = false, columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    var additionalGrants: MutableMap<String, Boolean> = mutableMapOf(),

    var externalId: String? = null,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var roleMappings: MutableList<UserRoleMapping> = mutableListOf(),

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
