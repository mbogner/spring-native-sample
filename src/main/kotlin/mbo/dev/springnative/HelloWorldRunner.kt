package mbo.dev.springnative

import mbo.dev.springnative.domain.role.RoleService
import mbo.dev.springnative.domain.user.UserService
import mbo.dev.springnative.domain.userrolemapping.UserRoleMappingService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service

@Service
class HelloWorldRunner(
    private val userService: UserService,
    private val roleService: RoleService,
    private val userRoleMappingService: UserRoleMappingService,
) : CommandLineRunner {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {
        log.info("RUNNING")
    }
}
