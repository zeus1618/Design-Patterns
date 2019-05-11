package com.madbunny.builderpattern.basic;

/**
 * @author iqbal on 2019-05-10
 * @project DesignPatterns
 */
public class User {
    private final int id;
    private final String name;

    public User(PeopleBuilder builder){
        id = builder.getId();
        name = builder.getName();
    }

    @Override
    public String toString() {
        return "\nUser : \nid: " + id + "\nname: " + name;
    }
}
