package com.madbunny.builderpattern.basic;

/**
 * @author iqbal on 2019-05-10
 * @project DesignPatterns
 */
public class BuilderPatternApp {
    public static void main(String[] args){
        PeopleBuilder peopleBuilder = PeopleBuilder.getInstance();
        peopleBuilder.setId(1).setName("Bella");
        User user = peopleBuilder.build();
        System.out.print(user);
    }
}
