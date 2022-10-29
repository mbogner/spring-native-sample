package mbo.dev.springnative.domain.userrolemapping

import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import mbo.dev.springnative.domain.AbstractModifiableEntity
import mbo.dev.springnative.domain.role.Role
import mbo.dev.springnative.domain.user.User
import org.jetbrains.annotations.NotNull
import java.time.Instant
import java.util.UUID

@Entity
@Table(
    uniqueConstraints = [
        UniqueConstraint(name = "uc_user_role_mapping__user_id_role_id", columnNames = ["user_id", "role_id"])
    ]
)
class UserRoleMapping(

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = ForeignKey(name = "fk_user_role_mapping__user_id"))
    var user: User,

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false, foreignKey = ForeignKey(name = "fk_user_role_mapping__role_id"))
    var role: Role,

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
