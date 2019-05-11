package com.madbunny.builderpattern.basic;

/**
 * @author iqbal on 2019-05-10
 * @project DesignPatterns
 */
public class PeopleBuilder {
    private int id;
    private String name;
    private Gender gender;

    public static PeopleBuilder getInstance(){
        return new PeopleBuilder();
    }

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

    public User build(){
        return new User(this);
    }
}