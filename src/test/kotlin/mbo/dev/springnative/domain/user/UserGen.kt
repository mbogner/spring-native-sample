package mbo.dev.springnative.domain.user

import java.util.UUID

class UserGen {

    companion object {
        fun validInstance(): User {
            return User(
                email = "${UUID.randomUUID().toString().substring(0, 8)}@example.com"
            )
        }
    }

}
