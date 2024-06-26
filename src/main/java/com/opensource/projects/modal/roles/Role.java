package com.opensource.projects.modal.roles;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    MEMBER (
            Set.of(
                    Permission.MEMBER_AUTH,
                    Permission.MEMBER_READ
            )
    ),
    ADMIN (
            Set.of(
                    Permission.ADMIN_AUTH,
                    Permission.ADMIN_CREATE,
                    Permission.ADMIN_READ,
                    Permission.CREATE_ADMIN
                    )
    ),

    SUB_ADMIN (
            Set.of(
                    Permission.ADMIN_AUTH,
                  Permission.ADMIN_READ,
                    Permission.ADMIN_CREATE
            )
    );

    @Getter
    public final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> grantedAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("Role_" + this.name()));
        return authorities;
    }
}
