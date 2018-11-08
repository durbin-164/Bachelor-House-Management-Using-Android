package com.example.root.bachlorhousemanagement;

/**
 * Created by root on 1/29/17.
 */

public class Member {
    private  int id;
    private  String name;
    private  int meal;

    public Member( int id,String name, int meal) {
        this.name = name;
        this.meal = meal;
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMeal() {
        return meal;
    }

    public void setMeal(int meal) {
        this.meal = meal;
    }
}
