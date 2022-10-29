package mbo.dev.springnative.domain.userrolemapping

import jakarta.persistence.EntityManager
import mbo.dev.springnative.domain.role.RoleGen
import mbo.dev.springnative.domain.user.UserGen

internal class UserRoleMappingGen {

    companion object {
        fun validInstance(em: EntityManager): UserRoleMapping {
            val mapping = UserRoleMapping(
                user = UserGen.validInstance(),
                role = RoleGen.validInstance(),
            )
            em.persist(mapping.user)
            em.persist(mapping.role)
            em.flush()
            return mapping
        }
    }

}
