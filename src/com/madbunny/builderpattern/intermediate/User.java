package com.madbunny.builderpattern.intermediate;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author iqbal on 2019-05-10
 * @project DesignPatterns
 *
 * Concrete Product
 */
public class User {
    private final int id;
    private final String name;
    private final Role role;
    private final ArrayList<String> permissions;

    public User(UserBuilder builder){
        id = builder.getId();
        name = builder.getName();
        role = builder.getRole();
        permissions = builder.getPermissions();
    }

    @Override
    public String toString() {
        return "\nUser : \nid: " + id
                + "\nname: " + name
                + "\nrole: " + role
                + "\npermissions: " + permissions.stream().collect(Collectors.joining(", "));
    }
}
