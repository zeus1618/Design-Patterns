package com.madbunny.builderpattern.intermediate;

/**
 * @author iqbal on 2019-05-10
 * @project DesignPatterns
 *
 * Structure
 * Director - Takes reference of Abstract builder and can perform operation based on what builder is being passed or can be simply perform common operations only
 * Abstract builder - Can provide any builder
 * Concrete builder - Builder with own definitions of common methods and can have method of it's own, result in one kind of product
 * Product - Product created can be very dynamic with few or all or none configurations
 *
 */
public class BuilderPatternApp {
    public static int id = 0;


    public static void main(String[] args){
        director(AdminBuilder.getInstance(), "zeus", PeopleBuilder.Gender.MALE);
        director(UserBuilder.getInstance(), "bella", PeopleBuilder.Gender.FEMALE);
        director(GuestBuilder.getInstance(), "rose", PeopleBuilder.Gender.FEMALE);
    }


    /**
     * Director
     * */
    public static void director(PeopleBuilder builder, String name, PeopleBuilder.Gender gender){
        builder.setId(++id)
            .setName(name)
            .setGender(gender)
            .resolveRole()
            .constructPermissions();
        System.out.println(builder.build().toString());
    }
}
