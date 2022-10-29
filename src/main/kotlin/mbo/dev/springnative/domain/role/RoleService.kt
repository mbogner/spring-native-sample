package mbo.dev.springnative.domain.role

import mbo.dev.springnative.domain.CrudService
import mbo.dev.springnative.domain.EntityService

@EntityService
class RoleService(repo: RoleRepository) : CrudService<Role>(repo) {
}
