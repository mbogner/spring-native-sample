package mbo.dev.springnative.domain.userrolemapping

import mbo.dev.springnative.domain.JpaRepositoryExt
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRoleMappingRepository : JpaRepositoryExt<UserRoleMapping, UUID> {
}
