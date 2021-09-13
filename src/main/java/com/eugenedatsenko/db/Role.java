package com.eugenedatsenko.db;

import com.eugenedatsenko.db.entity.User;

/**
 * Role entity.
 *
 * @author Y. Datsenko
 *
 */
public enum Role {
    ADMIN, USER;

    public static Role getRole(User user) {
        int roleId = user.getRoleId();
        return Role.values()[roleId - 1];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
