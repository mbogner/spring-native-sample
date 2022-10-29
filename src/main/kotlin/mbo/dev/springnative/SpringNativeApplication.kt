package mbo.dev.springnative

import mbo.dev.springnative.domain.JpaRepositoryExtImpl
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(
    repositoryBaseClass = JpaRepositoryExtImpl::class
)
@SpringBootApplication
class SpringNativeApplication()

fun main(args: Array<String>) {
    runApplication<SpringNativeApplication>(*args)
}
