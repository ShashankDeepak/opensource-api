package com.opensource.projects.modal.roles;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_AUTH("admin:auth"),
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    CREATE_ADMIN("create:admin"),
    MEMBER_READ("member:read"),
    MEMBER_AUTH("member:auth");

    @Getter
    private final String permission;
}
