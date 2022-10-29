package mbo.dev.springnative.domain.role

import jakarta.persistence.EntityManager
import mbo.dev.springnative.AbstractCrudServiceTest
import org.springframework.beans.factory.annotation.Autowired

internal class RoleServiceTest @Autowired constructor(
    repository: RoleRepository,
    em: EntityManager,
) : AbstractCrudServiceTest<Role>(RoleService(repository), em) {

    override fun validInstance(): Role {
        return RoleGen.validInstance()
    }

}
