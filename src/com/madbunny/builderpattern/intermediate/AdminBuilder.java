package com.madbunny.builderpattern.intermediate;

import java.util.ArrayList;

/**
 * @author iqbal on 2019-05-11
 * @project DesignPatterns
 *
 * Concrete Builder
 */
public class AdminBuilder extends PeopleBuilder<Admin> {

    public static PeopleBuilder getInstance() {
        return new AdminBuilder();
    }

    @Override
    public AdminBuilder resolveRole() {
        role = Role.ADMIN;
        return this;
    }

    @Override
    public AdminBuilder constructPermissions() {
        permissions = new ArrayList();
        permissions.add("createUser");
        permissions.add("read");
        permissions.add("createNewDocument");
        permissions.add("updateProfile");
        permissions.add("updateSelfDocument");
        permissions.add("updateUserDocument");
        return this;
    }

    @Override
    public Admin build() {
        return new Admin(this);
    }
}
