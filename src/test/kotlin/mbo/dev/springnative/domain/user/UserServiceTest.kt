package mbo.dev.springnative.domain.user

import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import mbo.dev.springnative.AbstractCrudServiceTest
import org.springframework.beans.factory.annotation.Autowired

@Transactional
internal class UserServiceTest @Autowired constructor(
    repo: UserRepository,
    em: EntityManager,
) : AbstractCrudServiceTest<User>(UserService(repo), em) { // workaround because repo isn't initialised in autowiring

    override fun validInstance(): User {
        return UserGen.validInstance()
    }

}
