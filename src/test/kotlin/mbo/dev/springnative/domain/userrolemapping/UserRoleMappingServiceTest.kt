package mbo.dev.springnative.domain.userrolemapping

import jakarta.persistence.EntityManager
import mbo.dev.springnative.AbstractCrdServiceTest
import org.springframework.beans.factory.annotation.Autowired

internal class UserRoleMappingServiceTest @Autowired constructor(
    repository: UserRoleMappingRepository,
    em: EntityManager,
) : AbstractCrdServiceTest<UserRoleMapping>(UserRoleMappingService(repository), em) {

    override fun validInstance(): UserRoleMapping {
        return UserRoleMappingGen.validInstance(em)
    }

}
