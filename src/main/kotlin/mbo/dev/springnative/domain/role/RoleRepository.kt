package mbo.dev.springnative.domain.role

import mbo.dev.springnative.domain.JpaRepositoryExt
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RoleRepository : JpaRepositoryExt<Role, UUID> {
}
