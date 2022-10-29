package mbo.dev.springnative.domain.user

import mbo.dev.springnative.domain.JpaRepositoryExt
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : JpaRepositoryExt<User, UUID> {
}
