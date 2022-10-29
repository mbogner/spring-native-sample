package mbo.dev.springnative.domain.userrolemapping

import mbo.dev.springnative.domain.CrdService
import mbo.dev.springnative.domain.EntityService

@EntityService
class UserRoleMappingService(repo: UserRoleMappingRepository) : CrdService<UserRoleMapping>(repo) {}
