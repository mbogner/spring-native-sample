package mbo.dev.springnative.domain.role

import java.util.UUID

class RoleGen {

    companion object {
        fun validInstance(): Role {
            return Role(
                name = UUID.randomUUID().toString().substring(0, 8)
            )
        }
    }

}
