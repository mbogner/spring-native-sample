DROP TABLE IF EXISTS user_role_mapping CASCADE;
CREATE TABLE user_role_mapping
(
    id           uuid                        not null default uuid_generate_v4()
        constraint pk_user_role_mapping primary key,
    created_at   timestamp without time zone not null default now_utc(),
    updated_at   timestamp without time zone
        constraint cc_user_role_mapping__create_before_update check (created_at <= updated_at),
    lock_version bigint                      not null default 0
        constraint cc_user_role_mapping__lock_version_positive check (lock_version >= 0),

    user_id uuid not null
        constraint fk_user_role_mapping__user_id references app_user (id),
    role_id uuid not null
        constraint fk_user_role_mapping__role_id references app_role (id)
) WITHOUT OIDS;

DROP TRIGGER IF EXISTS trg_user_role_mapping__check_created_at_unchanged ON user_role_mapping;
CREATE TRIGGER trg_user_role_mapping__check_created_at_unchanged
    BEFORE UPDATE
    ON user_role_mapping
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__check_created_at_unchanged();

DROP TRIGGER IF EXISTS trg_user_role_mapping__update_updated_at ON user_role_mapping;
CREATE TRIGGER trg_user_role_mapping__update_updated_at
    BEFORE UPDATE
    ON user_role_mapping
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__update_updated_at();

DROP TRIGGER IF EXISTS trg_user_role_mapping__increment_lock_version ON user_role_mapping;
CREATE TRIGGER trg_user_role_mapping__increment_lock_version
    BEFORE UPDATE
    ON user_role_mapping
    FOR EACH ROW
EXECUTE PROCEDURE trg_func__increment_lock_version();
