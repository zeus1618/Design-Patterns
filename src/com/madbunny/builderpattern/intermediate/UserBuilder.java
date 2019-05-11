package com.madbunny.builderpattern.intermediate;

import java.util.ArrayList;

/**
 * @author iqbal on 2019-05-11
 * @project DesignPatterns
 *
 * Concrete Builder
 */
public class UserBuilder extends PeopleBuilder<User> {

    public static PeopleBuilder getInstance() {
        return new UserBuilder();
    }

    @Override
    public UserBuilder resolveRole() {
        role = Role.USER;
        return this;
    }

    @Override
    public UserBuilder constructPermissions() {
        permissions = new ArrayList();
        permissions.add("read");
        permissions.add("createNewDocument");
        permissions.add("updateProfile");
        permissions.add("updateSelfDocument");
        return this;
    }

    @Override
    public User build() {
        return new User(this);
    }

}
