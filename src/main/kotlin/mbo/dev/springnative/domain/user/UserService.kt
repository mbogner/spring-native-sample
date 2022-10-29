package mbo.dev.springnative.domain.user

import mbo.dev.springnative.domain.CrudService
import mbo.dev.springnative.domain.EntityService

@EntityService
class UserService(repo: UserRepository) : CrudService<User>(repo) {}
