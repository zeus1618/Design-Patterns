package com.madbunny.builderpattern.intermediate;

import java.util.ArrayList;

/**
 * @author iqbal on 2019-05-11
 * @project DesignPatterns
 *
 * Concrete Builder
 */
public class GuestBuilder extends PeopleBuilder<Guest> {

    public static PeopleBuilder getInstance() {
        return new GuestBuilder();
    }

    @Override
    public GuestBuilder resolveRole() {
        role = Role.GUEST;
        return this;
    }

    @Override
    public GuestBuilder constructPermissions() {
        permissions = new ArrayList();
        permissions.add("readPublicDocs");
        return this;
    }

    @Override
    public Guest build() {
        return new Guest(this);
    }
}
