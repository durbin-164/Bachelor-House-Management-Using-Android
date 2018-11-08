package com.example.root.bachlorhousemanagement;

/**
 * Created by root on 2/2/17.
 */

public class UserData {
    private  int id;
    private  String userName;
    private  int numberOfMeal;
    private  int cost;

    public UserData() {
    }

    public UserData(int id, int cost, int numberOfMeal, String userName) {
        this.id = id;
        this.cost = cost;
        this.numberOfMeal = numberOfMeal;
        this.userName = userName;
    }

    public UserData(String userName, int numberOfMeal) {
        this.userName = userName;
        this.numberOfMeal = numberOfMeal;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumberOfMeal() {
        return numberOfMeal;
    }

    public void setNumberOfMeal(int numberOfMeal) {
        this.numberOfMeal = numberOfMeal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
