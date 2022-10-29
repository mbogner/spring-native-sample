DROP TABLE IF EXISTS app_role CASCADE;
CREATE TABLE app_role
(
    id           uuid                        not null default uuid_generate_v4()
        constraint pk_app_role primary key,
    created_at   timestamp without time zone not null default now_utc(),
    updated_at   timestamp without time zone
        constraint cc_app_role__create_before_update check (created_at <= updated_at),
    lock_version bigint                      not null default 0
        constraint cc_app_role__lock_version_positive check (lock_version >= 0),

    name         varchar(32)                 not null
        constraint uc_app_role__name unique,
    grants       jsonb                       not null default '{}'::jsonb
) WITHOUT OIDS;

DROP TRIGGER IF EXISTS trg_app_role__check_created_at_unchanged ON app_role;
CREATE TRIGGER trg_app_role__check_created_at_unchanged
    BEFORE UPDATE
    ON app_role
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__check_created_at_unchanged();

DROP TRIGGER IF EXISTS trg_app_role__update_updated_at ON app_role;
CREATE TRIGGER trg_app_role__update_updated_at
    BEFORE UPDATE
    ON app_role
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__update_updated_at();

DROP TRIGGER IF EXISTS trg_app_role__increment_lock_version ON app_role;
CREATE TRIGGER trg_app_role__increment_lock_version
    BEFORE UPDATE
    ON app_role
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__increment_lock_version();
