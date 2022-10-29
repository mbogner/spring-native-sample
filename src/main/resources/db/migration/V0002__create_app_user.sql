DROP TABLE IF EXISTS app_user CASCADE;
CREATE TABLE app_user
(
    id                uuid                        not null default uuid_generate_v4()
        constraint pk_app_user primary key,
    created_at        timestamp without time zone not null default now_utc(),
    updated_at        timestamp without time zone
        constraint cc_app_user__create_before_update check (created_at <= updated_at),
    lock_version      bigint                      not null default 0
        constraint cc_app_user__lock_version_positive check (lock_version >= 0),

    email             varchar(255)                not null
        constraint uc_app_user__email unique,
    active            boolean                     not null default true,
    additional_grants jsonb                       not null default '{}'::jsonb,
    external_id       varchar(255)
) WITHOUT OIDS;

DROP TRIGGER IF EXISTS trg_app_user__check_created_at_unchanged ON app_user;
CREATE TRIGGER trg_app_user__check_created_at_unchanged
    BEFORE UPDATE
    ON app_user
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__check_created_at_unchanged();

DROP TRIGGER IF EXISTS trg_app_user__update_updated_at ON app_user;
CREATE TRIGGER trg_app_user__update_updated_at
    BEFORE UPDATE
    ON app_user
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__update_updated_at();

DROP TRIGGER IF EXISTS trg_app_user__increment_lock_version ON app_user;
CREATE TRIGGER trg_app_user__increment_lock_version
    BEFORE UPDATE
    ON app_user
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__increment_lock_version();
