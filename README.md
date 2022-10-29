spring-native-sample
====================

Sample using the latest Spring Boot 3 libs for a JPA based application. I tried using constructor based field
definitions within the entities because the constructors are quite handy replacements for builders when using the named
version so that the order gets irrelevant.

Had an issue with dependency injection of repositories in my EntityService test. Used a workaround but would be nice if
someone could give me a hint what the problem is (repo just doesn't get injected if I inject the EntityService instances
directly).

```
2022-10-30 01:07:23.052  INFO [           main] StartupInfoLogger.java:56 : Starting AOT-processed SpringNativeApplicationKt using Java 19.0.1 on kronos.local with PID 24389 (/Users/manuel/workspace/private/spring-native/build/native/nativeCompile/spring-native started by manuel in /Users/manuel/workspace/private/spring-native/build/native/nativeCompile) {}
2022-10-30 01:07:23.052  INFO [           main] SpringApplication.java:630 : No active profile set, falling back to 1 default profile: "default" {}
2022-10-30 01:07:23.066  INFO [           main] Slf4jLog.java:37 : Flyway Community Edition 9.6.0 by Redgate {}
2022-10-30 01:07:23.066  INFO [           main] Slf4jLog.java:37 : See what's new here: https://flywaydb.org/documentation/learnmore/releaseNotes#9.6.0 {}
2022-10-30 01:07:23.066  INFO [           main] Slf4jLog.java:37 :  {}
2022-10-30 01:07:23.066  WARN [           main] Slf4jLog.java:41 : Unable to scan location: /db/migration (unsupported protocol: resource) {}
2022-10-30 01:07:23.066  WARN [           main] Slf4jLog.java:41 : Unable to scan location: /db/migration (unsupported protocol: resource) {}
2022-10-30 01:07:23.066  INFO [           main] HikariDataSource.java:110 : HikariPool-1 - Starting... {}
2022-10-30 01:07:23.117  INFO [           main] HikariPool.java:565 : HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection@87df384 {}
2022-10-30 01:07:23.117  INFO [           main] HikariDataSource.java:123 : HikariPool-1 - Start completed. {}
2022-10-30 01:07:23.119  INFO [           main] Slf4jLog.java:37 : Database: jdbc:postgresql://localhost:5432/db (PostgreSQL 15.0) {}
2022-10-30 01:07:23.133  INFO [           main] Slf4jLog.java:37 : Successfully validated 4 migrations (execution time 00:00.004s) {}
2022-10-30 01:07:23.145  INFO [           main] Slf4jLog.java:37 : Creating Schema History table "public"."flyway_schema_history" ... {}
2022-10-30 01:07:23.185  INFO [           main] Slf4jLog.java:37 : Current version of schema "public": << Empty Schema >> {}
2022-10-30 01:07:23.189  INFO [           main] Slf4jLog.java:37 : Migrating schema "public" to version "0001 - init" {}
2022-10-30 01:07:23.196  INFO [           main] Slf4jLog.java:37 : DB: function now_utc() does not exist, skipping {}
2022-10-30 01:07:23.199  INFO [           main] Slf4jLog.java:37 : DB: function trg_func__check_created_at_unchanged() does not exist, skipping {}
2022-10-30 01:07:23.202  INFO [           main] Slf4jLog.java:37 : DB: function trg_func__update_updated_at() does not exist, skipping {}
2022-10-30 01:07:23.204  INFO [           main] Slf4jLog.java:37 : DB: function trg_func__increment_lock_version() does not exist, skipping {}
2022-10-30 01:07:23.207  INFO [           main] Slf4jLog.java:37 : DB: function unknown_enum_value() does not exist, skipping {}
2022-10-30 01:07:23.224  INFO [           main] Slf4jLog.java:37 : Migrating schema "public" to version "0002 - create app user" {}
2022-10-30 01:07:23.227  INFO [           main] Slf4jLog.java:37 : DB: table "app_user" does not exist, skipping {}
2022-10-30 01:07:23.236  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_app_user__check_created_at_unchanged" for relation "app_user" does not exist, skipping {}
2022-10-30 01:07:23.238  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_app_user__update_updated_at" for relation "app_user" does not exist, skipping {}
2022-10-30 01:07:23.240  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_app_user__increment_lock_version" for relation "app_user" does not exist, skipping {}
2022-10-30 01:07:23.254  INFO [           main] Slf4jLog.java:37 : Migrating schema "public" to version "0003 - create app role" {}
2022-10-30 01:07:23.257  INFO [           main] Slf4jLog.java:37 : DB: table "app_role" does not exist, skipping {}
2022-10-30 01:07:23.265  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_app_role__check_created_at_unchanged" for relation "app_role" does not exist, skipping {}
2022-10-30 01:07:23.268  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_app_role__update_updated_at" for relation "app_role" does not exist, skipping {}
2022-10-30 01:07:23.269  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_app_role__increment_lock_version" for relation "app_role" does not exist, skipping {}
2022-10-30 01:07:23.283  INFO [           main] Slf4jLog.java:37 : Migrating schema "public" to version "0004 - create user role" {}
2022-10-30 01:07:23.286  INFO [           main] Slf4jLog.java:37 : DB: table "user_role_mapping" does not exist, skipping {}
2022-10-30 01:07:23.291  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_user_role_mapping__check_created_at_unchanged" for relation "user_role_mapping" does not exist, skipping {}
2022-10-30 01:07:23.293  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_user_role_mapping__update_updated_at" for relation "user_role_mapping" does not exist, skipping {}
2022-10-30 01:07:23.294  INFO [           main] Slf4jLog.java:37 : DB: trigger "trg_user_role_mapping__increment_lock_version" for relation "user_role_mapping" does not exist, skipping {}
2022-10-30 01:07:23.305  INFO [           main] Slf4jLog.java:37 : Successfully applied 4 migrations to schema "public", now at version v0004 (execution time 00:00.124s) {}
2022-10-30 01:07:23.313  INFO [           main] JDKLogger.java:64 : HHH000204: Processing PersistenceUnitInfo [name: default] {}
2022-10-30 01:07:23.314  INFO [           main] JDKLogger.java:64 : HHH000412: Hibernate ORM core version 6.1.4.Final {}
2022-10-30 01:07:23.315  WARN [           main] JDKLogger.java:64 : HHH90000021: Encountered deprecated setting [javax.persistence.sharedCache.mode], use [jakarta.persistence.sharedCache.mode] instead {}
2022-10-30 01:07:23.320  INFO [           main] JDKLogger.java:64 : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQLDialect {}
2022-10-30 01:07:23.356  INFO [           main] JDKLogger.java:64 : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform] {}
2022-10-30 01:07:23.356  INFO [           main] AbstractEntityManagerFactoryBean.java:437 : Initialized JPA EntityManagerFactory for persistence unit 'default' {}
2022-10-30 01:07:23.388  INFO [           main] StartupInfoLogger.java:62 : Started SpringNativeApplicationKt in 0.348 seconds (process running for 0.362) {}
2022-10-30 01:07:23.388  INFO [           main] HelloWorldRunner.kt:21 : RUNNING {}
2022-10-30 01:07:23.388  INFO [ionShutdownHook] AbstractEntityManagerFactoryBean.java:650 : Closing JPA EntityManagerFactory for persistence unit 'default' {}
2022-10-30 01:07:23.388  INFO [ionShutdownHook] HikariDataSource.java:350 : HikariPool-1 - Shutdown initiated... {}
2022-10-30 01:07:23.389  INFO [ionShutdownHook] HikariDataSource.java:352 : HikariPool-1 - Shutdown completed. {}
```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.0-RC1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.0-RC1/gradle-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.0.0-RC1/reference/html/native-image.html#native-image)
* [Testcontainers Postgres Module Reference Guide](https://www.testcontainers.org/modules/databases/postgres/)
* [Validation](https://docs.spring.io/spring-boot/docs/3.0.0-RC1/reference/htmlsingle/#io.validation)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.0-RC1/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.0.0-RC1/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)
* [Testcontainers](https://www.testcontainers.org/)

### Guides

The following guides illustrate how to use some features concretely:

* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.0.0-RC1/gradle-plugin/reference/htmlsingle/#aot)

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks

If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./gradlew bootBuildImage
```

Then, you can run the app like any other container:

```
$ docker run --rm spring-native:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools

Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./gradlew nativeCompile
```

Then, you can run the app as follows:

```
$ build/native/nativeCompile/spring-native
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./gradlew nativeTest
```

