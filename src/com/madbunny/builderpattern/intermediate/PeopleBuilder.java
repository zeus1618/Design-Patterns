package com.madbunny.builderpattern.intermediate;

import java.util.ArrayList;

/**
 * @author iqbal on 2019-05-10
 * @project DesignPatterns
 *
 * Abstract Builder
 */
public abstract class PeopleBuilder<T> {
    private int id;
    private String name;
    private Gender gender;
    protected Role role;
    protected ArrayList<String> permissions;

    public static PeopleBuilder getInstance(){
        //User is default Builder
        return new UserBuilder();
    }

    public abstract PeopleBuilder resolveRole();
    public abstract PeopleBuilder constructPermissions();
    public abstract T build();

    public enum Gender{
        MALE, FEMALE
    }

    public PeopleBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PeopleBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PeopleBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }
}